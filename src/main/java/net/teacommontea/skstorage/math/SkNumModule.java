package net.teacommontea.skstorage.math;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.classes.Serializer;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ch.njol.yggdrasil.Fields;
import org.skriptlang.skript.lang.arithmetic.Arithmetics;
import org.skriptlang.skript.lang.arithmetic.Operator;
import org.skriptlang.skript.lang.comparator.Comparators;
import org.skriptlang.skript.lang.comparator.Relation;
import org.skriptlang.skript.lang.converter.Converters;

public final class SkNumModule {

    private SkNumModule() {}

    public static void register(Logger log) {
        registerClassInfo();
        registerSkNumArithmetic();
        registerNumberOverride();
        registerComparators();
        registerConverters();
        evictArithmeticCaches(log);
        log.info("Registered exact math engine (SkNum: long -> BigInteger -> BigDecimal, no silent loss)");
    }

    private static void registerClassInfo() {
        Classes.registerClass(new ClassInfo<>(SkNum.class, "sknum")
            .user("sknums?", "big ?nums?")
            .name("Number (exact)")
            .description(
                "An exact number that never silently loses precision.",
                "Stays a fast machine integer until an operation would overflow, then",
                "promotes to an unbounded exact integer; uses exact decimals for",
                "fractional values, rounding only when a value repeats forever (e.g. 10/3).")
            .since("2.0.0")
            .parser(new Parser<SkNum>() {
                @Override
                public boolean canParse(ParseContext context) {
                    return context == ParseContext.PARSE;
                }

                @Override
                public SkNum parse(String s, ParseContext context) {
                    try {
                        return SkNum.parse(s);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }

                @Override
                public String toString(SkNum n, int flags) {
                    return n.toString();
                }

                @Override
                public String toVariableNameString(SkNum n) {
                    return n.toString();
                }
            })
            .serializer(new Serializer<SkNum>() {
                @Override
                public Fields serialize(SkNum n) {
                    Fields f = new Fields();

                    f.putObject("value", n.toString());
                    f.putPrimitive("rounded", n.isRounded());
                    return f;
                }

                @Override
                protected boolean canBeInstantiated() {
                    return false;
                }

                @Override
                public boolean mustSyncDeserialization() {
                    return false;
                }

                @Override
                protected SkNum deserialize(Fields f) throws java.io.StreamCorruptedException {
                    try {
                        String value = f.getObject("value", String.class);
                        boolean rounded = f.getPrimitive("rounded", boolean.class);
                        SkNum parsed = SkNum.parse(value);

                        return rounded ? SkNum.ofBigDecimal(parsed.toBigDecimal(), true) : parsed;
                    } catch (Exception e) {
                        throw new java.io.StreamCorruptedException("bad SkNum: " + e.getMessage());
                    }
                }

                @Override
                public void deserialize(SkNum n, Fields f) throws java.io.StreamCorruptedException {
                    throw new java.io.StreamCorruptedException("SkNum is immutable");
                }
            }));
    }

    private static void registerSkNumArithmetic() {
        Arithmetics.registerOperation(Operator.ADDITION, SkNum.class, SkMath::add);
        Arithmetics.registerOperation(Operator.SUBTRACTION, SkNum.class, SkMath::subtract);
        Arithmetics.registerOperation(Operator.MULTIPLICATION, SkNum.class, SkMath::multiply);
        Arithmetics.registerOperation(Operator.DIVISION, SkNum.class, SkMath::divide);
        Arithmetics.registerOperation(Operator.EXPONENTIATION, SkNum.class, SkMath::pow);

        Arithmetics.registerOperation(Operator.ADDITION, SkNum.class, Number.class,
            (a, n) -> SkMath.add(a, SkNum.fromNumber(n)),
            (n, a) -> SkMath.add(SkNum.fromNumber(n), a));
        Arithmetics.registerOperation(Operator.SUBTRACTION, SkNum.class, Number.class,
            (a, n) -> SkMath.subtract(a, SkNum.fromNumber(n)),
            (n, a) -> SkMath.subtract(SkNum.fromNumber(n), a));
        Arithmetics.registerOperation(Operator.MULTIPLICATION, SkNum.class, Number.class,
            (a, n) -> SkMath.multiply(a, SkNum.fromNumber(n)),
            (n, a) -> SkMath.multiply(SkNum.fromNumber(n), a));
        Arithmetics.registerOperation(Operator.DIVISION, SkNum.class, Number.class,
            (a, n) -> SkMath.divide(a, SkNum.fromNumber(n)),
            (n, a) -> SkMath.divide(SkNum.fromNumber(n), a));
        Arithmetics.registerOperation(Operator.EXPONENTIATION, SkNum.class, Number.class,
            (a, n) -> SkMath.pow(a, SkNum.fromNumber(n)));

        Arithmetics.registerDifference(SkNum.class, SkMath::difference);
        Arithmetics.registerDefaultValue(SkNum.class, () -> SkNum.ZERO);
    }

    private static void registerNumberOverride() {

        tryRegisterNumberOp(Operator.ADDITION, (a, b) -> unwrap(SkMath.add(wrap(a), wrap(b))));
        tryRegisterNumberOp(Operator.SUBTRACTION, (a, b) -> unwrap(SkMath.subtract(wrap(a), wrap(b))));
        tryRegisterNumberOp(Operator.MULTIPLICATION, (a, b) -> unwrap(SkMath.multiply(wrap(a), wrap(b))));
        tryRegisterNumberOp(Operator.DIVISION, (a, b) -> unwrap(SkMath.divide(wrap(a), wrap(b))));
        tryRegisterNumberOp(Operator.EXPONENTIATION, (a, b) -> unwrap(SkMath.pow(wrap(a), wrap(b))));
    }

    @FunctionalInterface
    private interface NumberOp {
        Number apply(Number a, Number b);
    }

    private static void tryRegisterNumberOp(Operator operator, NumberOp op) {
        try {
            Arithmetics.registerOperation(operator, Number.class, op::apply);
        } catch (RuntimeException alreadyRegistered) {

        }
    }

    private static SkNum wrap(Number n) {
        return SkNum.fromNumber(n);
    }

    private static Number unwrap(SkNum n) {
        return switch (n.kind()) {
            case LONG -> n.rawLong();
            case BIG_INT -> n.rawBigInt();
            case BIG_DEC -> n.rawBigDec();
        };
    }

    private static void registerComparators() {
        Comparators.registerComparator(SkNum.class, SkNum.class,
            (a, b) -> Relation.get(a.compareTo(b)));
        Comparators.registerComparator(SkNum.class, Number.class,
            (a, n) -> Relation.get(a.compareTo(SkNum.fromNumber(n))));
    }

    private static void registerConverters() {
        Converters.registerConverter(Number.class, SkNum.class, SkNum::fromNumber);

        Converters.registerConverter(SkNum.class, Number.class, SkNumModule::unwrap);
    }

    private static void evictArithmeticCaches(Logger log) {
        for (String field : new String[]{"CACHED_OPERATIONS", "CACHED_CONVERTED_OPERATIONS"}) {
            try {
                Field f = Arithmetics.class.getDeclaredField(field);
                f.setAccessible(true);
                Object value = f.get(null);
                if (value instanceof Map<?, ?> map) {
                    map.clear();
                }
            } catch (NoSuchFieldException e) {
                log.warning("exact math: Arithmetics." + field + " not found on this Skript build; "
                    + "engine may not take effect until first use.");
            } catch (Throwable t) {
                log.warning("exact math: could not clear Arithmetics." + field + ": " + t.getMessage());
            }
        }
    }
}
