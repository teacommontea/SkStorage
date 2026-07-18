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
import net.teacommontea.skstorage.util.Log;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "Config Migrator",
    excerpt = "Keeps an existing config.yml in sync with the bundled defaults by pruning retired keys and appending newly added blocks.",
    dev = true,
    detail = "A stateless utility invoked during plugin load to reconcile the user's on-disk config.yml against the version shipped inside the jar. prune removes any top-level keys listed in the DEAD_KEYS set (currently only skip_math) so retired options do not linger. sync compares the top-level keys of the bundled resource against the user's file and text-appends any missing top-level block, comment lines and all, preserving the original formatting rather than round-tripping through a YAML serializer. Blocks are located and sliced with a hand-rolled line scanner (extractTopLevelBlock) that treats an unindented non-comment key line as the start of the next block and carries along trailing indented lines and inline comments. Top-level keys are read via a real YamlConfiguration parse with a manual line-scan fallback if parsing throws. Both entry points return the list of keys they changed so the caller can log and trigger a reloadConfig.",
    webEquivalent = "A schema/config migration step run at boot, similar to a database migration runner or a dotfile merge tool that adds new default settings and drops deprecated ones without clobbering user edits.",
    notes = "Newly appended blocks are copied verbatim from the bundled config.yml, so their default values and explanatory comments are preserved. All failures are logged softly and treated as no-ops so a config read/write error never blocks startup.",
    caveats = "Only top-level keys are reconciled; changes to nested keys within an already-present block are not detected or migrated. The text-based block extraction assumes the shipped config.yml keeps one blank line between top-level blocks."
)
public final class ConfigUpdater {

    private ConfigUpdater() {}

    private static final List<String> DEAD_KEYS = List.of(
        "skip_math"
    );

    public static List<String> prune(JavaPlugin plugin) {
        List<String> removed = new ArrayList<>();
        Path userFile = plugin.getDataFolder().toPath().resolve("config.yml");
        if (!Files.exists(userFile)) return removed;

        Set<String> userKeys;
        try {
            userKeys = topLevelKeys(Files.readString(userFile, StandardCharsets.UTF_8));
        } catch (IOException e) {
            Log.soft("ConfigUpdater: cannot read config.yml for prune: " + e.getMessage());
            return removed;
        }

        for (String key : DEAD_KEYS) {
            if (userKeys.contains(key) && removeTopLevelKey(plugin, key)) {
                removed.add(key);
            }
        }
        return removed;
    }

    public static List<String> sync(JavaPlugin plugin) {
        List<String> added = new ArrayList<>();
        Path userFile = plugin.getDataFolder().toPath().resolve("config.yml");
        if (!Files.exists(userFile)) return added;

        Set<String> userKeys;
        Set<String> defaultKeys;
        try {
            userKeys = topLevelKeys(Files.readString(userFile, StandardCharsets.UTF_8));
        } catch (IOException e) {
            Log.soft("ConfigUpdater: cannot read config.yml: " + e.getMessage());
            return added;
        }

        String defaultText = readResource(plugin, "config.yml");
        if (defaultText == null) {
            Log.soft("ConfigUpdater: bundled config.yml resource not found.");
            return added;
        }
        defaultKeys = topLevelKeys(defaultText);

        StringBuilder appendix = new StringBuilder();
        for (String key : defaultKeys) {
            if (userKeys.contains(key)) continue;
            String block = extractTopLevelBlock(defaultText, key);
            if (block == null) continue;
            appendix.append('\n').append(block);
            if (!block.endsWith("\n")) appendix.append('\n');
            added.add(key);
        }

        if (!added.isEmpty()) {
            try {
                String current = Files.readString(userFile, StandardCharsets.UTF_8);
                if (!current.endsWith("\n")) current += "\n";
                Files.writeString(userFile, current + appendix, StandardCharsets.UTF_8);
            } catch (IOException e) {
                Log.soft("ConfigUpdater: failed to append missing keys: " + e.getMessage());
                return new ArrayList<>();
            }
        }
        return added;
    }

    public static boolean removeTopLevelKey(JavaPlugin plugin, String key) {
        Path userFile = plugin.getDataFolder().toPath().resolve("config.yml");
        try {
            String text = Files.readString(userFile, StandardCharsets.UTF_8);
            String block = extractTopLevelBlock(text, key);
            if (block == null) return false;

            String updated;
            if (text.contains(block + "\n\n")) {
                updated = text.replace(block + "\n\n", "");
            } else if (text.contains("\n" + block)) {
                updated = text.replace("\n" + block, "");
            } else {
                updated = text.replace(block, "");
            }
            Files.writeString(userFile, updated, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            Log.soft("ConfigUpdater: failed to remove key '" + key + "': " + e.getMessage());
            return false;
        }
    }

    private static Set<String> topLevelKeys(String yaml) {
        Set<String> keys = new LinkedHashSet<>();
        YamlConfiguration parsed = new YamlConfiguration();
        try {
            parsed.loadFromString(yaml);
            keys.addAll(parsed.getKeys(false));
        } catch (Exception ignored) {

            for (String line : yaml.split("\n", -1)) {
                if (line.isEmpty() || line.charAt(0) == ' ' || line.charAt(0) == '#' || line.charAt(0) == '\t') continue;
                int colon = line.indexOf(':');
                if (colon > 0) keys.add(line.substring(0, colon).trim());
            }
        }
        return keys;
    }

    private static String extractTopLevelBlock(String text, String key) {
        String[] lines = text.split("\n", -1);
        int start = -1;
        for (int i = 0; i < lines.length; i++) {
            String l = lines[i];
            if (!l.isEmpty() && l.charAt(0) != ' ' && l.charAt(0) != '\t' && l.charAt(0) != '#') {
                int colon = l.indexOf(':');
                if (colon > 0 && l.substring(0, colon).trim().equals(key)) {
                    start = i;
                    break;
                }
            }
        }
        if (start < 0) return null;

        int end = lines.length;
        for (int i = start + 1; i < lines.length; i++) {
            String l = lines[i];

            if (!l.isEmpty() && l.charAt(0) != ' ' && l.charAt(0) != '\t' && l.charAt(0) != '#'
                && l.indexOf(':') > 0) {
                end = i;
                break;
            }
        }

        int lastBody = start;
        for (int i = start + 1; i < end; i++) {
            String l = lines[i];
            boolean indented = !l.isEmpty() && (l.charAt(0) == ' ' || l.charAt(0) == '\t');
            if (indented) {
                lastBody = i;
            } else if (l.isEmpty()) {

                break;
            } else if (l.charAt(0) == '#') {

                lastBody = i;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= lastBody; i++) {
            sb.append(lines[i]);
            if (i < lastBody) sb.append('\n');
        }
        return sb.toString();
    }

    private static String readResource(JavaPlugin plugin, String name) {
        try (InputStream in = plugin.getResource(name)) {
            if (in == null) return null;
            Reader r = new InputStreamReader(in, StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[4096];
            int n;
            while ((n = r.read(buf)) != -1) sb.append(buf, 0, n);
            return sb.toString();
        } catch (IOException e) {
            return null;
        }
    }
}
