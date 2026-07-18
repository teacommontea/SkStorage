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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import net.teacommontea.skstorage.math.SkNum.Kind;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "Exact arithmetic operations",
    excerpt = "The arithmetic kernel of the exact math engine: add, subtract, multiply, divide, power, negate, abs, and difference on SkNum values with automatic type promotion.",
    dev = true,
    detail = "Stateless helpers that implement each operation with a tiered strategy that keeps values exact and as narrow as possible. When both operands are plain longs it uses Math.addExact/subtractExact/multiplyExact and promotes to BigInteger only on overflow; multiplication also has a fast path that turns multiplication by a power of two into a bit shift when it cannot overflow. When both operands are integers (long or BigInteger) it computes in BigInteger; otherwise it computes in BigDecimal. Division stays exact when it divides evenly, otherwise falls back to a rounded quotient using the shared 50-digit HALF_UP MathContext and marks the result rounded. Exponentiation handles integer exponents exactly via BigInteger/BigDecimal pow (including negative exponents as reciprocals), guards against exponents too large to evaluate, and falls back to double Math.pow (rounded) only for non-integer exponents. negate, abs, and difference are derived from the above and preserve the exact representation. A rounded flag propagates through operations so a value that ever lost exactness stays marked.",
    webEquivalent = "The core operations of a big-decimal or rational arithmetic library, comparable to BigDecimal/BigInteger method chains or decimal.js operations with a fixed rounding context.",
    notes = "Consumed by SkNumModule, which registers these methods as Skript's arithmetic operations. The long fast paths and power-of-two shift exist purely for performance on the common small-integer case.",
    caveats = "Division by zero and 0 raised to a negative power throw ArithmeticException. Non-integer exponents route through double Math.pow, so those results are inherently rounded (flagged as such) rather than exact, and an infinite or NaN power throws."
)
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
