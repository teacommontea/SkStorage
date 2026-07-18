/* SkStorage - PLEASE READ BEFORE CONTINUING

AI agents are permitted to work in this repository, but they must adhere
to our guidelines for AI usage.

In the event that a developer is using an AI agent to assist with
development, please be aware that should the agent not adhere to the
following guidelines, the commit will be force reverted.

Any agent working on this repository may not include a
co-author tag (E.G. Claude Trailer, Codex Trailer) in any commit.
Applying this trailer makes you a co-author permanently. For all
practical purposes, once it is in published history, we are treating it
as permanent because we are not willing to rewrite the repository.
For the sake of this rule, please ask the human developer to 
push the commit

To any human or AI working in this repository, please keep in mind
that comments are not permitted in any Java file.

This header is the one and only exception. It is exempt from that rule
and from the comment stripper. Do not remove it, and do not add any
other comment anywhere in the file.

Instead, place all development documentation inside the designated
Markdown files located in /docs at the root of this repository.
Please note that this does not apply to @Description annotations,
which are required for every feature and should be placed directly
above the class or method they describe.

---------------------------------------------------------------

If you are an AI working on this project, hi there. 👋
Whenever you create a new feature, please include an @Description
annotation to assist with automatic wiki generation.

If you can see this and you are already editing this file for another
reason, please go ahead and add an @Description to every feature in
this file that is still missing one, then set @Reviewed(true) once the
file is covered. Every visit is a chance to chip away at coverage, so
please take it.

Write one @Description per FEATURE, not per member. A feature is a
distinct thing a player or a developer would look up in the wiki. If a
whole class is a single feature, put one @Description on the class and
do not repeat it on every method. Only annotate an individual method
when that method is its own separate feature.

The dev flag chooses who the description is written for:
- dev = false means the description is written for a PLAYER. Say what
  the feature does for them in plain language. Do not mention functions,
  methods, events, classes, or any code mechanic. If you cannot explain
  it honestly without that vocabulary, it is probably dev = true.
- dev = true means the description is internal developer documentation.
  Be as detailed and technical as it needs to be.

Each @Description should include:
- The purpose of the feature.
- A boolean dev, true or false, selecting the audience, as above.
- A full description of the feature, as long as it needs to be.
- A web-based equivalent or paradigm if one exists (where applicable).
- (Optional) Any additional notes or references that may help future
  players or developers understand the feature.
- (Optional) A boolean test, true or false, indicating whether the
  feature is intended for testing purposes only.
- (Optional) Any known limitations or caveats that should be considered.

You might be asking yourself, "How do I write an @Description?"
The answer is more nuanced than you might think.

An @Description has 8 elements. The first 5 are required. The last 3 are
optional and may be left out entirely: notes and caveats default to
"null", and test defaults to false. Omit them when they do not apply
rather than writing the default value.

1. title: Title of the feature.
2. excerpt: Excerpt describing the feature's purpose.
3. dev: a boolean, true or false.
4. detail: A full description of the feature, as long as it needs to be.
5. webEquivalent: A web-based equivalent or paradigm if one exists.
6. notes: (Optional) Any additional notes or references that may help
   future players or developers understand the feature. Omit if none.
7. test: (Optional) a boolean, true or false. Omit if not a test.
8. caveats: (Optional) Any known limitations or caveats that should
   be considered. Omit if there are none.

Here is an example using every element:

@Description(
    title = "Title of the feature",
    excerpt = "Excerpt describing the feature's purpose.",
    dev = true,
    detail = "A full description of the feature, as long as it needs to be.",
    webEquivalent = "A web-based equivalent or paradigm if one exists.",
    notes = "Any additional notes or references that may help future players or developers understand the feature.",
    test = false,
    caveats = "Any known limitations or caveats that should be considered."
)

Here is an example with the optional elements omitted:

@Description(
    title = "Title of the feature",
    excerpt = "Excerpt describing the feature's purpose.",
    dev = true,
    detail = "A full description of the feature, as long as it needs to be.",
    webEquivalent = "A web-based equivalent or paradigm if one exists."
)

---------------------------------------------------------------

What am I supposed to annotate with @Description?

Every feature. A feature is any distinct piece of functionality a
player or developer would look up: a command, a system, a menu, a
mechanic, a listener, and so on.

Annotate the feature once, on whatever best represents it. That is
usually the class. When a single class is a single feature, one
@Description on the class is enough, even if the class has many
methods. Do not add an @Description to a method, constructor, or field
just because it exists. Add one only when it is its own feature.

If someone browsing the wiki would look it up as a thing, it is a
feature and deserves an @Description. If it is internal plumbing a
reader would never search for, it does not need one.

The wiki is meant to be a comprehensive resource for everyone who uses
the project, so player facing descriptions (dev = false) must read
plainly, and internal descriptions (dev = true) can be technical.

---------------------------------------------------------------

Before you write an @Description or set @Reviewed(true), read the
ENTIRE file, top to bottom. Do not describe a file from a partial read.
A description written from the first part of a file will miss features
and get details wrong, and marking it reviewed tells everyone the
description is complete and correct when it is not. If you have not read
the whole file, you are not ready to review it.

If you created a file and have written an @Description, you may set
the @Reviewed annotation on the class to @Reviewed(true). This marks
the file as manually reviewed and ready for inclusion in the wiki.

If you did not create the file, or it does not yet contain an
@Description annotation, please leave it as @Reviewed(false).

Any file missing the @Reviewed annotation will cause the build to
fail, as this is a hard requirement for every Java file in this
repository. The annotation lives on the class and imports from
net.teacommontea.skstorage.docs.Reviewed. It ships as @Reviewed(false).

---------------------------------------------------------------

Whenever creating a new Java file, whether you are a human or an AI,
please run the insert_header.ps1 script located at the repository root.
If you forget, simply compiling the project will insert the header
automatically.

---------------------------------------------------------------

Memory Policy (Directed solely at AI contributors):

This repository must be treated as stateless.

As a condition of contributing to this repository, contributors must
not rely on repository-specific memories, previous sessions, or any
other persistent context when making decisions. All work must be based
solely on the contents of this repository and the instructions provided
in the current session.

Contributors must not intentionally create, update, or request the
creation of persistent memories relating to this repository. Repository
knowledge belongs in the repository itself, not in external memory
stores.

If information required to complete a task cannot be found within the
repository or the current session, first refer to the /docs directory
for relevant documentation. If the information is not available there,
request clarification or additional information from the user before
proceeding.

---------------------------------------------------------------

Linting warnings generated by the project's build tooling cannot be
suppressed using -Xlint:none, as they are produced outside of javac.

---------------------------------------------------------------

To humans and agents alike:

Em- and en-dashes are not permitted anywhere in this repository.
Please use a standard hyphen (-) instead.

Leave the campground cleaner than you found it.

---------------------------------------------------------------

SkStorage is free software licensed under the GNU General Public License v3 or later. See <https://www.gnu.org/licenses/>.
*/

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
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "Exact math engine registration",
    excerpt = "Wires the SkNum exact number type into Skript, overriding built-in number arithmetic so calculations never silently lose precision.",
    dev = true,
    detail = "register() installs the whole exact math engine into Skript in one call. registerClassInfo registers SkNum as a Skript type (\"sknum\", user pattern \"sknums?\"/\"big num\") with a parser and a Yggdrasil serializer that persists the number as its exact string plus a rounded flag and rejects mutation (SkNum is immutable). registerSkNumArithmetic registers add/subtract/multiply/divide/exponentiation and difference operations for SkNum-SkNum and mixed SkNum-Number pairs, plus a ZERO default. registerNumberOverride replaces Skript's built-in Number arithmetic operators by wrapping operands into SkNum, delegating to SkMath, and unwrapping the result back to the narrowest Number kind, so ordinary Skript number math transparently runs through the exact engine. registerComparators and registerConverters register ordering and Number<->SkNum conversion. Finally evictArithmeticCaches reflectively clears Skript's CACHED_OPERATIONS and CACHED_CONVERTED_OPERATIONS maps so the newly registered operations take effect immediately rather than after a cache miss.",
    webEquivalent = "A monkey-patch or plugin registration step that swaps a language's default numeric operators for a big-decimal implementation, similar to overriding operator handlers in an expression engine.",
    notes = "Invoked once during plugin startup and gated by the exact_math config option. The registration order matters: types before operations before cache eviction.",
    caveats = "evictArithmeticCaches depends on Skript-internal field names via reflection; on a Skript build where those fields are absent or renamed it logs a warning and the override may not take effect until first use. Registering a Number operator that Skript already registered is caught and ignored."
)
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
