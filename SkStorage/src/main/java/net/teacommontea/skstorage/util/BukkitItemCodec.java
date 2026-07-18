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

package net.teacommontea.skstorage.util;

import ch.njol.skript.aliases.ItemType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "Bukkit Item Codec",
    excerpt = "Serializes Skript item variables into native Bukkit item bytes so items survive being saved to and loaded from the database intact.",
    dev = true,
    detail = "A stateless codec for turning Skript itemtype and itemstack variable values into a stable byte representation and back. isItemType recognizes the Skript type strings itemtype and itemstack. toItemStack coerces a live variable value into a cloned ItemStack (unwrapping an ItemType via getRandom). encode uses ItemStack.serializeAsBytes and decode uses ItemStack.deserializeBytes, giving full-fidelity NBT-aware round-tripping instead of Skript's default representation. toItemType rewraps a decoded stack back into a Skript ItemType. The nested Result value type reports whether the codec intercepted a write and carries the type marker and value bytes; intercept is the main entry point used by the storage layer: for an item-typed variable it reads the current live value via SkriptReflect, serializes it, and returns an intercepted Result stamped with the TYPE_MARKER (_skstorage_bukkit_item), otherwise it returns a passthrough Result leaving the original type and bytes untouched. All encode/decode failures degrade gracefully to null or passthrough.",
    webEquivalent = "A custom serializer/deserializer registered on a data store, similar to a JPA AttributeConverter or a Jackson custom (de)serializer that swaps a rich domain object for a portable binary blob on the way to and from storage.",
    notes = "The TYPE_MARKER constant is the sentinel type string persisted alongside the bytes so the load path knows a value was produced by this codec rather than by Skript's normal serialization.",
    caveats = "Serialized item bytes are tied to Bukkit's item format and may not deserialize cleanly across major server versions. intercept relies on reading the current live variable value through reflection, so it only intercepts values still resolvable at write time."
)
public final class BukkitItemCodec {

    public static final String TYPE_MARKER = "_skstorage_bukkit_item";

    private BukkitItemCodec() {}

    public static boolean isItemType(@Nullable String type) {
        return "itemtype".equals(type) || "itemstack".equals(type);
    }

    @Nullable
    public static ItemStack toItemStack(@Nullable Object value) {
        if (value == null) return null;
        if (value instanceof ItemStack stack) return stack.clone();
        if (value instanceof ItemType type) {
            ItemStack stack = type.getRandom();
            if (stack != null) return stack.clone();
        }
        return null;
    }

    @Nullable
    public static byte[] encode(@Nullable ItemStack stack) {
        if (stack == null) return null;
        try {
            return stack.serializeAsBytes();
        } catch (Throwable t) {
            return null;
        }
    }

    @Nullable
    public static ItemStack decode(@Nullable byte[] bytes) {
        if (bytes == null || bytes.length == 0) return null;
        try {
            return ItemStack.deserializeBytes(bytes);
        } catch (Throwable t) {
            return null;
        }
    }

    @Nullable
    public static ItemType toItemType(@Nullable ItemStack stack) {
        if (stack == null) return null;
        try {
            return new ItemType(stack);
        } catch (Throwable t) {
            return null;
        }
    }

    public static final class Result {
        public final boolean intercepted;
        public final String type;
        public final byte[] value;

        private Result(boolean intercepted, String type, byte[] value) {
            this.intercepted = intercepted;
            this.type = type;
            this.value = value;
        }

        static Result passthrough(String type, byte[] value) {
            return new Result(false, type, value);
        }

        static Result intercepted(byte[] bukkitBytes) {
            return new Result(true, TYPE_MARKER, bukkitBytes);
        }
    }

    public static Result intercept(String name, @Nullable String type, @Nullable byte[] value) {
        if (!isItemType(type) || value == null) return Result.passthrough(type, value);
        Object live = SkriptReflect.getVariable(name);
        ItemStack stack = toItemStack(live);
        if (stack == null) return Result.passthrough(type, value);
        byte[] encoded = encode(stack);
        if (encoded == null) return Result.passthrough(type, value);
        return Result.intercepted(encoded);
    }
}
