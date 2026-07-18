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

package net.teacommontea.skstorage.migrate;
import net.teacommontea.skstorage.util.Log;

import net.teacommontea.skstorage.SkStoragePlugin;
import net.teacommontea.skstorage.route.SkStorageRouter;
import net.teacommontea.skstorage.route.Table;
import net.teacommontea.skstorage.util.ConfigUpdater;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "CSV Converter",
    excerpt = "One-time import of Skript's legacy variables.csv file into the default.db table.",
    dev = true,
    detail = "Runs at startup only when convert_csv.enabled is true in config. Locates Skript's variable dump by looking for variables.csv (or variables.csv.bak) inside the sibling plugins/Skript directory. Streams the file line by line, skipping blank lines and comment lines beginning with '#', and parses each row with a quote-aware CSV regex that unescapes doubled quotes. Each row is expected to hold name, type, and a hex-encoded value; the value is decoded from hex (rejecting odd-length or non-hex strings) and rows missing a name, type, or value are skipped. Every valid row is written into the router's default.db table via Table.save, then the table is flushed once at the end. Regardless of outcome, the convert_csv key is removed from config.yml through ConfigUpdater.removeTopLevelKey and the config is reloaded, so the conversion can only ever run once. Old CSV files are intentionally left on disk for the operator to remove manually after verifying the import.",
    webEquivalent = "A one-shot CSV bulk-import script, like COPY FROM in PostgreSQL or a spreadsheet import wizard that disables itself after running.",
    notes = "All rows go into default.db regardless of routing patterns. Intended mainly for development migration to .db format, not general production use.",
    caveats = "Self-deleting: the config key is stripped after the first run whether or not the CSV existed, so re-running requires re-adding convert_csv to config. Does not delete the source CSV files. If the default table is unavailable or the file read fails, the import aborts (in the read-failure case the config key may already have been left in place)."
)
public final class CsvConverter {

    private CsvConverter() {}

    private static final Pattern CSV_LINE =
        Pattern.compile("(?<=^|,)\\s*(?:([^\",]*)|\"((?:[^\"]+|\"\")*)\")\\s*(?:,|$)");

    public static void runIfEnabled(SkStoragePlugin plugin) {
        if (!plugin.getConfig().getBoolean("convert_csv.enabled", false)) return;

        SkStorageRouter router = plugin.getRouter();
        Table target = router != null ? router.defaultTable() : null;
        if (target == null) {
            Log.soft("convert_csv: no default.db table available; skipping.");
            return;
        }

        Path csv = locateCsv(plugin);
        if (csv == null) {
            Log.soft("convert_csv: no variables.csv found (looked in plugins/Skript/). " +
                "Nothing to convert; disabling the option.");
            ConfigUpdater.removeTopLevelKey(plugin, "convert_csv");
            return;
        }

        long imported = 0, skipped = 0;
        try (BufferedReader r = Files.newBufferedReader(csv, StandardCharsets.UTF_8)) {
            String line;
            while ((line = r.readLine()) != null) {
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] cols = splitCsv(line);
                if (cols.length < 2 || cols[0] == null || cols[0].isEmpty()) { skipped++; continue; }
                String name = cols[0];
                String type = cols.length >= 2 ? cols[1] : null;
                byte[] value = (cols.length >= 3 && cols[2] != null && !cols[2].isEmpty())
                    ? hexDecode(cols[2]) : null;
                if (type == null || type.isEmpty() || value == null) {

                    skipped++;
                    continue;
                }
                if (target.save(name, type, value)) imported++; else skipped++;
            }
            target.flush();
        } catch (IOException e) {
            Log.hard("convert_csv: read failed: " + e.getMessage());
            return;
        }

        plugin.getLogger().info("convert_csv: imported " + imported + " row(s) into default.db (" +
            skipped + " skipped). Your old CSV files were NOT deleted; remove them manually after verifying.");
        ConfigUpdater.removeTopLevelKey(plugin, "convert_csv");
        plugin.reloadConfig();
    }

    private static Path locateCsv(SkStoragePlugin plugin) {

        Path skriptDir = plugin.getDataFolder().toPath().getParent().resolve("Skript");
        for (String n : new String[]{"variables.csv", "variables.csv.bak"}) {
            Path p = skriptDir.resolve(n);
            if (Files.exists(p)) return p;
        }
        return null;
    }

    private static String[] splitCsv(String line) {
        java.util.List<String> out = new java.util.ArrayList<>();
        Matcher m = CSV_LINE.matcher(line);
        while (m.find()) {
            if (m.group(1) != null) {
                out.add(m.group(1).trim());
            } else if (m.group(2) != null) {
                out.add(m.group(2).replace("\"\"", "\"").trim());
            } else {
                out.add("");
            }
            if (m.end() == line.length()) break;
        }
        return out.toArray(new String[0]);
    }

    private static byte[] hexDecode(String hex) {
        int len = hex.length();
        if ((len & 1) != 0) return null;
        byte[] out = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            int hi = Character.digit(hex.charAt(i), 16);
            int lo = Character.digit(hex.charAt(i + 1), 16);
            if (hi < 0 || lo < 0) return null;
            out[i / 2] = (byte) ((hi << 4) | lo);
        }
        return out;
    }
}
