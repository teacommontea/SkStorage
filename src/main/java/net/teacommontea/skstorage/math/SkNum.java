package net.teacommontea.skstorage.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

public final class SkNum extends Number implements Comparable<SkNum> {

    enum Kind { LONG, BIG_INT, BIG_DEC }

    public static final SkNum ZERO = ofLong(0L);
    public static final SkNum ONE = ofLong(1L);
    public static final SkNum TEN = ofLong(10L);

    private final Kind kind;
    private final long asLong;
    private final BigInteger asBigInt;
    private final BigDecimal asBigDec;

    private final boolean rounded;

    private SkNum(Kind kind, long asLong, BigInteger asBigInt, BigDecimal asBigDec, boolean rounded) {
        this.kind = kind;
        this.asLong = asLong;
        this.asBigInt = asBigInt;
        this.asBigDec = asBigDec;
        this.rounded = rounded;
    }

    public static SkNum ofLong(long v) {
        return new SkNum(Kind.LONG, v, null, null, false);
    }

    public static SkNum ofBigInteger(BigInteger v) {
        Objects.requireNonNull(v, "value");

        if (v.bitLength() < 63) {
            return ofLong(v.longValue());
        }
        return new SkNum(Kind.BIG_INT, 0L, v, null, false);
    }

    public static SkNum ofBigDecimal(BigDecimal v) {
        return ofBigDecimal(v, false);
    }

    public static SkNum ofBigDecimal(BigDecimal v, boolean rounded) {
        Objects.requireNonNull(v, "value");
        BigDecimal stripped = v.stripTrailingZeros();

        if (!rounded && stripped.scale() <= 0) {
            return ofBigInteger(stripped.toBigIntegerExact());
        }
        return new SkNum(Kind.BIG_DEC, 0L, null, stripped, rounded);
    }

    public static SkNum fromNumber(Number n) {
        Objects.requireNonNull(n, "number");
        if (n instanceof SkNum sk) {
            return sk;
        }
        if (n instanceof Long || n instanceof Integer || n instanceof Short || n instanceof Byte) {
            return ofLong(n.longValue());
        }
        if (n instanceof BigInteger bi) {
            return ofBigInteger(bi);
        }
        if (n instanceof BigDecimal bd) {
            return ofBigDecimal(bd);
        }
        double d = n.doubleValue();
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new ArithmeticException("cannot represent " + d + " as an exact number");
        }
        if (d == Math.rint(d) && Math.abs(d) < 9.007199254740992E15D) {
            return ofLong((long) d);
        }

        return ofBigDecimal(new BigDecimal(d));
    }

    public static SkNum parse(String s) {
        Objects.requireNonNull(s, "string");
        String t = s.trim();
        if (t.isEmpty()) {
            throw new NumberFormatException("empty");
        }
        BigDecimal bd = new BigDecimal(t);
        return ofBigDecimal(bd);
    }

    Kind kind() { return kind; }
    long rawLong() { return asLong; }
    BigInteger rawBigInt() { return asBigInt; }
    BigDecimal rawBigDec() { return asBigDec; }

    public boolean isRounded() {
        return rounded;
    }

    public boolean isInteger() {
        return kind != Kind.BIG_DEC;
    }

    public boolean isZero() {
        return switch (kind) {
            case LONG -> asLong == 0L;
            case BIG_INT -> asBigInt.signum() == 0;
            case BIG_DEC -> asBigDec.signum() == 0;
        };
    }

    public int signum() {
        return switch (kind) {
            case LONG -> Long.signum(asLong);
            case BIG_INT -> asBigInt.signum();
            case BIG_DEC -> asBigDec.signum();
        };
    }

    public boolean fitsInLong() {
        return kind == Kind.LONG;
    }

    public BigDecimal toBigDecimal() {
        return switch (kind) {
            case LONG -> BigDecimal.valueOf(asLong);
            case BIG_INT -> new BigDecimal(asBigInt);
            case BIG_DEC -> asBigDec;
        };
    }

    public BigInteger toBigInteger() {
        return switch (kind) {
            case LONG -> BigInteger.valueOf(asLong);
            case BIG_INT -> asBigInt;
            case BIG_DEC -> asBigDec.toBigInteger();
        };
    }

    public double toDouble() {
        return doubleValue();
    }

    @Override
    public int intValue() {
        return (int) longValue();
    }

    @Override
    public long longValue() {
        return switch (kind) {
            case LONG -> asLong;
            case BIG_INT -> asBigInt.longValue();
            case BIG_DEC -> asBigDec.longValue();
        };
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return switch (kind) {
            case LONG -> (double) asLong;
            case BIG_INT -> asBigInt.doubleValue();
            case BIG_DEC -> asBigDec.doubleValue();
        };
    }

    @Override
    public int compareTo(SkNum o) {

        if (kind == Kind.LONG && o.kind == Kind.LONG) {
            return Long.compare(asLong, o.asLong);
        }

        if (isInteger() && o.isInteger()) {
            return toBigInteger().compareTo(o.toBigInteger());
        }
        return toBigDecimal().compareTo(o.toBigDecimal());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SkNum other)) return false;

        return compareTo(other) == 0;
    }

    @Override
    public int hashCode() {

        return toBigDecimal().stripTrailingZeros().hashCode();
    }

    @Override
    public String toString() {
        return switch (kind) {
            case LONG -> Long.toString(asLong);
            case BIG_INT -> asBigInt.toString();
            case BIG_DEC -> asBigDec.toPlainString();
        };
    }

    public static final class Config {
        private Config() {}

        public static final int PRECISION = 50;

        public static final RoundingMode ROUNDING = RoundingMode.HALF_UP;

        private static final MathContext CONTEXT = new MathContext(PRECISION, ROUNDING);

        public static MathContext context() {
            return CONTEXT;
        }
    }
}
