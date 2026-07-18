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

import ch.njol.skript.variables.Variables;
import ch.njol.skript.variables.VariablesStorage;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "Skript Reflection Bridge",
    excerpt = "Reaches into Skript's non-public variable internals via reflection so the storage layer can drive variable loading and routing.",
    dev = true,
    detail = "A stateless reflection shim that exposes three otherwise-inaccessible Skript hooks. A static initializer resolves and unlocks VariablesStorage.variableNamePattern and Variables.variableLoaded once at class load, throwing ExceptionInInitializerError with a version-incompatibility message if either member is missing. setNamePattern writes the private variableNamePattern field on a storage instance, letting SkStorage control which variable names a storage claims. variableLoaded invokes Skript's package-private variableLoaded to notify the engine that a variable has been read in from storage, returning its boolean result. getVariable lazily resolves and caches the private Variables.getVariable(String, Event, boolean) method and calls it to fetch the current live value of a variable by name, returning null if the method is absent on this Skript build. Reflection failures are wrapped in RuntimeExceptions with descriptive messages.",
    webEquivalent = "A reflection-based adapter against a third-party library's private API, similar to using Java reflection or a bytecode bridge to call internal framework methods that were never exposed publicly.",
    notes = "The name-pattern field and variableLoaded method are resolved eagerly at class load so incompatibility surfaces immediately; getVariable is resolved lazily and cached in a volatile field on first use.",
    caveats = "Tightly coupled to Skript's internal field and method names; a Skript update that renames or removes any of them breaks this bridge (eagerly for the first two, returning null for getVariable). Depends on the JVM permitting setAccessible on these members."
)
public final class SkriptReflect {

    private static final Field VARIABLE_NAME_PATTERN;
    private static final Method VARIABLE_LOADED;

    static {
        try {
            VARIABLE_NAME_PATTERN = VariablesStorage.class.getDeclaredField("variableNamePattern");
            VARIABLE_NAME_PATTERN.setAccessible(true);
            VARIABLE_LOADED = Variables.class.getDeclaredMethod(
                "variableLoaded", String.class, Object.class, VariablesStorage.class);
            VARIABLE_LOADED.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            throw new ExceptionInInitializerError(
                "SkStorage incompatible with this Skript version: " + e.getMessage());
        }
    }

    private SkriptReflect() {}

    public static void setNamePattern(VariablesStorage storage, @Nullable Pattern pattern) {
        try {
            VARIABLE_NAME_PATTERN.set(storage, pattern);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to set variableNamePattern: " + e.getMessage(), e);
        }
    }

    public static boolean variableLoaded(String name, @Nullable Object value, VariablesStorage source) {
        try {
            return (Boolean) VARIABLE_LOADED.invoke(null, name, value, source);
        } catch (Exception e) {
            throw new RuntimeException("variableLoaded reflection failed: " + e.getMessage(), e);
        }
    }

    private static volatile Method GET_VARIABLE;

    @Nullable
    public static Object getVariable(String name) {
        try {
            if (GET_VARIABLE == null) {
                Method m = ch.njol.skript.variables.Variables.class
                    .getDeclaredMethod("getVariable", String.class, org.bukkit.event.Event.class, boolean.class);
                m.setAccessible(true);
                GET_VARIABLE = m;
            }
            return GET_VARIABLE.invoke(null, name, null, false);
        } catch (NoSuchMethodException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("getVariable reflection failed: " + e.getMessage(), e);
        }
    }
}
