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

package net.teacommontea.skstorage.route;

import net.teacommontea.skstorage.SkStoragePlugin;
import org.bukkit.configuration.ConfigurationSection;

import java.io.File;
import java.util.logging.Logger;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "Table configuration builder",
    excerpt = "Reads config.yml and constructs the router's tables, patterns, and default catch-all from user-defined table sections.",
    dev = true,
    detail = "build() scans the plugin config for user-defined table sections and registers each as a route on the SkStorageRouter. It first honors a top-level database: false (persistence disabled, returns false) and simple_mode (a single permanent default.db table that ignores all other definitions). Otherwise it iterates every top-level config key, skipping a reserved set of non-table sections (player, litebans, plotsquared, playerdata, experimental, skript, convert_csv), any section flagged example: true, and any section lacking database: true. For each valid table it requires a non-empty patterns string, parses it into a VariablePattern, and reads split_file_by_uuid, permanent, and index. A split_file_by_uuid table whose pattern is not UUID-keyed is downgraded to single-file with a warning. It builds the Table (a directory location when split, otherwise a <key>.db file), adds the route with an incrementing declaration order for tie-breaking, and finally always registers a default.db catch-all whose permanence follows default_permanent. SQLite behavior (WAL, file locking) and shard character count are pulled from config and passed through to each Table.",
    webEquivalent = "A configuration loader or dependency-injection wiring step that turns declarative config into runtime routing rules, similar to parsing a routes or virtual-hosts file into handler objects.",
    notes = "Reserved keys correspond to plugin subsystem config sections rather than storage tables. declOrder is passed to addRoute so that later-declared tables win ties at equal index.",
    caveats = "Malformed table sections (missing or unparseable patterns) are skipped with a warning rather than failing the load. simple_mode overrides every other table definition."
)
public final class TableConfig {

    private TableConfig() {}

    private static final java.util.Set<String> RESERVED = java.util.Set.of(
        "player", "litebans", "plotsquared", "playerdata",
        "experimental", "skript", "convert_csv");

    public static boolean build(SkStoragePlugin plugin, SkStorageRouter router) {
        Logger log = plugin.getLogger();
        ConfigurationSection cfg = plugin.getConfig();
        File dataDir = plugin.getDataFolder();
        int shardChars = cfg.getInt("player.shard-chars", 2);

        boolean defaultPermanent = cfg.getBoolean("default_permanent", true);

        if (cfg.isSet("database") && !cfg.getBoolean("database", true)) {
            log.warning("Top-level database: false; persistence is disabled.");
            return false;
        }

        net.teacommontea.skstorage.util.SqliteSetup.Options sqliteOptions =
            new net.teacommontea.skstorage.util.SqliteSetup.Options(
                cfg.getBoolean("experimental.disable_wal", false),
                cfg.getBoolean("experimental.skip_file_locking", false));

        if (cfg.getBoolean("simple_mode", false)) {
            Table only = new Table("default", false, true, Integer.MIN_VALUE,
                new File(dataDir, "default.db"), shardChars, sqliteOptions);
            router.setDefaultTable(only);
            log.info("Simple mode ON: all variables route to default.db (tables ignored).");
            return true;
        }

        int declOrder = 0;
        int tableCount = 0;
        for (String key : cfg.getKeys(false)) {
            if (RESERVED.contains(key)) continue;
            ConfigurationSection sec = cfg.getConfigurationSection(key);
            if (sec == null) continue;

            if (sec.getBoolean("example", false)) continue;
            if (!sec.isSet("database")) continue;

            if (!sec.getBoolean("database", false)) {

                continue;
            }

            String rawPattern = sec.getString("patterns");
            if (rawPattern == null || rawPattern.isEmpty()) {
                log.warning("Table '" + key + "' has database: true but no patterns; skipping.");
                continue;
            }

            VariablePattern pattern = VariablePattern.parse(rawPattern);
            if (pattern == null) {
                log.warning("Table '" + key + "' pattern failed to parse: " + rawPattern + "; skipping.");
                continue;
            }

            boolean split = sec.getBoolean("split_file_by_uuid", false);
            boolean permanent = sec.getBoolean("permanent", false);
            int index = sec.getInt("index", 0);

            if (split && !pattern.isUuidKeyed()) {
                log.warning("Table '" + key + "' sets split_file_by_uuid but its pattern has no UUID; " +
                    "files cannot be sharded by UUID. Treating as single-file.");
                split = false;
            }

            File location = split
                ? new File(dataDir, key)
                : new File(dataDir, key + ".db");
            Table table = new Table(key, split, permanent, index, location, shardChars, sqliteOptions);
            router.addRoute(table, pattern, index, declOrder++);
            tableCount++;
            log.info("Registered table '" + key + "' (index=" + index +
                ", split_file_by_uuid=" + split + ", permanent=" + permanent + ")");
        }

        Table def = new Table("default", false, defaultPermanent, Integer.MIN_VALUE,
            new File(dataDir, "default.db"), shardChars, sqliteOptions);
        router.setDefaultTable(def);

        log.info("Routing built: " + tableCount + " table(s) + default.db (permanent=" +
            defaultPermanent + ")");
        return true;
    }
}
