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
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "SkNum exact number type",
    excerpt = "An immutable arbitrary-precision number that backs SkStorage's exact math engine, avoiding the silent overflow and precision loss of primitive doubles.",
    dev = true,
    detail = "An immutable Number/Comparable that internally stores a value as one of three kinds: a primitive long (fast path), a BigInteger (exact large integers), or a BigDecimal (exact decimals). Factory methods (ofLong, ofBigInteger, ofBigDecimal, fromNumber, parse) normalize to the narrowest representation that stays exact: BigIntegers small enough collapse to long, and BigDecimals with no fractional part collapse to integer kinds. fromNumber converts any Java Number, rejecting NaN and infinity and lifting doubles to exact form. It exposes value queries (isInteger, isZero, signum, isRounded, fitsInLong) and lossless conversions (toBigDecimal, toBigInteger) alongside the lossy Number conversions (intValue, longValue, floatValue, doubleValue). Equality and ordering are value-based across kinds (compareTo/equals compare numeric value regardless of representation, and hashCode is computed on the trailing-zero-stripped BigDecimal so equal numbers hash alike). The nested Config holds the shared MathContext (50-digit precision, HALF_UP rounding) used by the wider math engine. The rounded flag records when a BigDecimal value resulted from a rounded operation.",
    webEquivalent = "A big-number or decimal library value such as JavaScript's BigInt plus decimal.js, or Java's BigDecimal, used so financial or large-integer values never lose precision.",
    notes = "Backs the exact_math config option; when enabled SkStorage routes Skript number math through this type instead of Skript's native math. ZERO, ONE, and TEN are shared constants.",
    caveats = "equals is consistent with compareTo (value equality across representations), so it deliberately ignores the kind and the rounded flag. The lossy Number conversions (longValue, doubleValue, etc.) can still overflow or lose precision by design, since they exist for interoperability."
)
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
