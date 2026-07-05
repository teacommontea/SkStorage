package net.teacommontea.skstorage.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import net.teacommontea.skstorage.math.SkNum.Kind;

public final class SkMath {

    private SkMath() {}

    public static SkNum add(SkNum a, SkNum b) {
        if (bothLong(a, b)) {
            try {
                return SkNum.ofLong(Math.addExact(a.rawLong(), b.rawLong()));
            } catch (ArithmeticException overflow) {

                return SkNum.ofBigInteger(BigInteger.valueOf(a.rawLong()).add(BigInteger.valueOf(b.rawLong())));
            }
        }
        if (bothInteger(a, b)) {
            return SkNum.ofBigInteger(a.toBigInteger().add(b.toBigInteger()));
        }

        return SkNum.ofBigDecimal(a.toBigDecimal().add(b.toBigDecimal()), anyRounded(a, b));
    }

    public static SkNum subtract(SkNum a, SkNum b) {
        if (bothLong(a, b)) {
            try {
                return SkNum.ofLong(Math.subtractExact(a.rawLong(), b.rawLong()));
            } catch (ArithmeticException overflow) {
                return SkNum.ofBigInteger(BigInteger.valueOf(a.rawLong()).subtract(BigInteger.valueOf(b.rawLong())));
            }
        }
        if (bothInteger(a, b)) {
            return SkNum.ofBigInteger(a.toBigInteger().subtract(b.toBigInteger()));
        }
        return SkNum.ofBigDecimal(a.toBigDecimal().subtract(b.toBigDecimal()), anyRounded(a, b));
    }

    public static SkNum multiply(SkNum a, SkNum b) {
        if (bothLong(a, b)) {

            SkNum shifted = tryShiftMultiply(a, b);
            if (shifted != null) {
                return shifted;
            }
            try {
                return SkNum.ofLong(Math.multiplyExact(a.rawLong(), b.rawLong()));
            } catch (ArithmeticException overflow) {
                return SkNum.ofBigInteger(BigInteger.valueOf(a.rawLong()).multiply(BigInteger.valueOf(b.rawLong())));
            }
        }
        if (bothInteger(a, b)) {

            return SkNum.ofBigInteger(a.toBigInteger().multiply(b.toBigInteger()));
        }
        return SkNum.ofBigDecimal(a.toBigDecimal().multiply(b.toBigDecimal()), anyRounded(a, b));
    }

    private static SkNum tryShiftMultiply(SkNum a, SkNum b) {
        long left = a.rawLong();
        long right = b.rawLong();
        int shift = powerOfTwoShift(right);
        if (shift <= 0) {
            return null;
        }

        if (shift < 63 && Math.abs(left) <= (Long.MAX_VALUE >> shift)) {
            return SkNum.ofLong(left << shift);
        }
        return null;
    }

    public static SkNum divide(SkNum a, SkNum b) {
        if (b.isZero()) {
            throw new ArithmeticException("/ by zero");
        }
        if (bothInteger(a, b)) {
            BigInteger dividend = a.toBigInteger();
            BigInteger divisor = b.toBigInteger();
            BigInteger[] qr = dividend.divideAndRemainder(divisor);
            if (qr[1].signum() == 0) {

                return SkNum.ofBigInteger(qr[0]);
            }

            return decimalDivide(new BigDecimal(dividend), new BigDecimal(divisor), false);
        }
        return decimalDivide(a.toBigDecimal(), b.toBigDecimal(), anyRounded(a, b));
    }

    private static SkNum decimalDivide(BigDecimal a, BigDecimal b, boolean carryRounded) {
        try {

            BigDecimal exact = a.divide(b);
            return SkNum.ofBigDecimal(exact, carryRounded);
        } catch (ArithmeticException nonTerminating) {
            BigDecimal rounded = a.divide(b, SkNum.Config.context());
            return SkNum.ofBigDecimal(rounded, true);
        }
    }

    public static SkNum pow(SkNum base, SkNum exponent) {

        if (exponent.isInteger()) {
            BigInteger e = exponent.toBigInteger();
            if (e.signum() == 0) {
                return SkNum.ONE;
            }
            boolean negative = e.signum() < 0;
            BigInteger magnitude = e.abs();

            if (magnitude.bitLength() > 31) {
                throw new ArithmeticException("exponent too large to evaluate: " + exponent);
            }
            int exp = magnitude.intValueExact();

            if (base.isInteger()) {
                BigInteger result = base.toBigInteger().pow(exp);
                if (!negative) {
                    return SkNum.ofBigInteger(result);
                }

                if (result.signum() == 0) {
                    throw new ArithmeticException("0 raised to a negative power");
                }
                return decimalDivide(BigDecimal.ONE, new BigDecimal(result), false);
            }

            if (!negative) {
                return SkNum.ofBigDecimal(base.toBigDecimal().pow(exp), base.isRounded());
            }
            BigDecimal positive = base.toBigDecimal().pow(exp);
            return decimalDivide(BigDecimal.ONE, positive, base.isRounded());
        }

        double result = Math.pow(base.toDouble(), exponent.toDouble());
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            throw new ArithmeticException("undefined power: " + base + " ^ " + exponent);
        }
        return SkNum.ofBigDecimal(
            new BigDecimal(result).round(SkNum.Config.context()), true);
    }

    public static SkNum negate(SkNum a) {
        return switch (a.kind()) {
            case LONG -> a.rawLong() == Long.MIN_VALUE
                ? SkNum.ofBigInteger(BigInteger.valueOf(a.rawLong()).negate())
                : SkNum.ofLong(-a.rawLong());
            case BIG_INT -> SkNum.ofBigInteger(a.rawBigInt().negate());
            case BIG_DEC -> SkNum.ofBigDecimal(a.rawBigDec().negate(), a.isRounded());
        };
    }

    public static SkNum abs(SkNum a) {
        return a.signum() < 0 ? negate(a) : a;
    }

    public static SkNum difference(SkNum a, SkNum b) {
        return abs(subtract(a, b));
    }

    private static boolean bothLong(SkNum a, SkNum b) {
        return a.kind() == Kind.LONG && b.kind() == Kind.LONG;
    }

    private static boolean bothInteger(SkNum a, SkNum b) {
        return a.isInteger() && b.isInteger();
    }

    private static boolean anyRounded(SkNum a, SkNum b) {
        return a.isRounded() || b.isRounded();
    }

    private static int powerOfTwoShift(long v) {
        if (v <= 0 || (v & (v - 1)) != 0) {
            return -1;
        }
        return Long.numberOfTrailingZeros(v);
    }
}
