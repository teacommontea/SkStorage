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

import ch.njol.skript.Skript;
import ch.njol.skript.config.SectionNode;
import ch.njol.skript.variables.VariablesStorage;
import net.teacommontea.skstorage.util.Log;
import net.teacommontea.skstorage.SkStoragePlugin;
import net.teacommontea.skstorage.util.SkriptReflect;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "SkStorage variable router",
    excerpt = "Skript VariablesStorage implementation that routes each variable to the correct table by pattern precedence and drives load, save, and flush.",
    dev = true,
    detail = "Subclasses Skript's VariablesStorage and registers itself as the storage backend for variables. It holds a list of Route entries (each pairing a Table with a VariablePattern, an index, and a declaration order) plus an optional default catch-all Table. addRoute keeps the route list sorted by descending index then descending declaration order, so route(name) returns the highest-precedence matching table and falls back to the default table when nothing matches. load_i builds the tables from config via TableConfig.build, optionally removes an orphaned _disabled.db, opens every table, installs an accept-all name pattern through SkriptReflect, loads every stored variable back into Skript, and registers itself on the plugin. save() routes the incoming write to the correct table. routeExplain returns an Explain record describing which table, pattern, and index a name would resolve to without writing, backing the /skstorage route command. connect/disconnect/close/flushAll manage the lifecycle of all owned tables.",
    webEquivalent = "A request router or reverse-proxy rule table that dispatches keys to backends by longest-prefix or highest-priority match, with a default upstream.",
    notes = "requiresFile returns false because this backend manages its own files rather than a single Skript-supplied database file. The accept pattern is forced to .* so Skript hands every variable to this storage.",
    caveats = "Route precedence ties are broken by declaration order (last defined wins). If no default table is configured and a name matches nothing, save returns false and the write is silently dropped."
)
public final class SkStorageRouter extends VariablesStorage {

    public static final class Route {
        final Table table;
        final VariablePattern pattern;
        final int index;
        final int declOrder;

        Route(Table table, VariablePattern pattern, int index, int declOrder) {
            this.table = table;
            this.pattern = pattern;
            this.index = index;
            this.declOrder = declOrder;
        }
    }

    private final List<Route> routes = new ArrayList<>();
    @Nullable private Table defaultTable;
    private final boolean ignoreInvalid;

    private volatile boolean killed = false;
    @Nullable private Table disabledTable;

    public SkStorageRouter(String type) {
        super(type);
        this.ignoreInvalid = SkStoragePlugin.get().getConfig()
            .getBoolean("experimental.ignore_invalid_files", true);
    }

    public void addRoute(Table table, VariablePattern pattern, int index, int declOrder) {
        routes.add(new Route(table, pattern, index, declOrder));

        routes.sort((a, b) -> {
            int c = Integer.compare(b.index, a.index);
            return c != 0 ? c : Integer.compare(b.declOrder, a.declOrder);
        });
    }

    public void setDefaultTable(Table table) {
        this.defaultTable = table;
    }

    public List<Route> routes() {
        return routes;
    }

    @Nullable
    public Table defaultTable() {
        return defaultTable;
    }

    public List<Table> allTables() {
        List<Table> out = new ArrayList<>(routes.size() + 1);
        for (Route r : routes) out.add(r.table);
        if (defaultTable != null) out.add(defaultTable);
        return out;
    }

    @Nullable
    public Table route(String name) {
        if (killed) return disabledTable;
        for (Route r : routes) {
            if (r.pattern.matches(name)) return r.table;
        }
        return defaultTable;
    }

    public Explain routeExplain(String name) {
        if (killed) {
            return new Explain("_disabled", null, 0, true, "database is killed");
        }
        for (Route r : routes) {
            if (r.pattern.matches(name)) {
                return new Explain(r.table.name(), r.pattern.raw(), r.index, false, null);
            }
        }
        return new Explain(defaultTable != null ? defaultTable.name() : "(none)",
            null, Integer.MIN_VALUE, false, "no pattern matched");
    }

    public record Explain(String table, @Nullable String pattern, int index,
                          boolean killed, @Nullable String note) {}

    public boolean isKilled() {
        return killed;
    }

    @Description(
        title = "Live database kill and revive (flatline)",
        excerpt = "Safely suspends the storage layer at runtime by flushing and closing all tables and diverting further writes to a throwaway _disabled.db, then restores them on revive.",
        dev = true,
        detail = "kill() flushes and closes every real table, then opens a single permanent stub table named _disabled backed by _disabled.db and flips the killed flag. While killed, route() returns the stub so Skript keeps writing normally but all writes land in the throwaway file, and routeExplain reports the killed state. revive() flushes and closes the stub, optionally deletes _disabled.db (and its -shm/-wal sidecars) via deleteDisabledDb, reopens all real tables, and clears the flag. This lets an operator take the database offline for a safe plugin reload without stopping the server, without Skript noticing the backend is gone.",
        webEquivalent = "Putting a service into maintenance mode behind a null sink, then draining and restoring it, similar to toggling a feature flag that routes traffic to a no-op backend.",
        notes = "Exposed to operators through the /skstorage kill and /skstorage alive commands. Both methods are synchronized to prevent overlapping kill/revive transitions.",
        caveats = "Writes made while killed go to _disabled.db and are discarded on revive (or on startup cleanup); they are intentionally not merged back into the real tables."
    )
    public synchronized void kill(File dataDir) {
        if (killed) return;
        flushAll();
        for (Table t : allTables()) t.close();
        try {
            disabledTable = new Table("_disabled", false, true, Integer.MIN_VALUE,
                new File(dataDir, "_disabled.db"), 2, net.teacommontea.skstorage.util.SqliteSetup.Options.DEFAULT);
            disabledTable.open();
        } catch (Exception e) {
            Log.hard("kill: could not open _disabled.db: " + e.getMessage());
        }
        killed = true;
    }

    public synchronized void revive(File dataDir, boolean deleteDisabled) {
        if (!killed) return;
        if (disabledTable != null) {
            disabledTable.flush();
            disabledTable.close();
            disabledTable = null;
        }
        if (deleteDisabled) {
            deleteDisabledDb(dataDir);
        }
        try {
            for (Table t : allTables()) t.open();
        } catch (Exception e) {
            Log.hard("revive: could not reopen tables: " + e.getMessage());
        }
        killed = false;
    }

    public static void deleteDisabledDb(File dataDir) {
        File f = new File(dataDir, "_disabled.db");
        f.delete();
        new File(f.getAbsolutePath() + "-shm").delete();
        new File(f.getAbsolutePath() + "-wal").delete();
    }

    public int purgeUuidEverywhere(String uuid) {
        int total = 0;
        for (Table t : allTables()) {
            total += t.purgeUuid(uuid);
        }
        return total;
    }

    public int purgeByGlobEverywhere(String glob) {
        int total = 0;
        for (Table t : allTables()) {
            total += t.purgeByGlob(glob);
        }
        return total;
    }

    @Description(
        title = "Player profile merge by UUID",
        excerpt = "Moves every stored variable belonging to one UUID onto another UUID across all tables, re-routing each moved variable to its correct destination table.",
        dev = true,
        detail = "Flushes all pending writes, collects every raw row whose name contains fromUuid from every table, and for each row rewrites the name by replacing fromUuid with toUuid. Each rewritten name is re-routed through route() so it lands in whatever table now matches it, skipping rows whose name is unchanged and rows that already exist at the destination (existing target values are never overwritten). After saving the moved rows it flushes again and purges every trace of fromUuid from all tables, returning the number of variables moved.",
        webEquivalent = "A database account-merge or identity-consolidation job that reassigns all records from one primary key to another and deletes the source.",
        notes = "Backs the /skstorage merge command used to combine two player profiles, for example after an account UUID change.",
        caveats = "Destructive: the source UUID's data is deleted after the move. Collisions are resolved in favor of the destination, so a variable already present on toUuid is kept and the fromUuid copy is discarded."
    )
    public int mergeUuid(String fromUuid, String toUuid) {
        flushAll();
        java.util.List<Table.RawRow> rows = new java.util.ArrayList<>();
        for (Table t : allTables()) {
            rows.addAll(t.readRowsContaining(fromUuid));
        }
        int moved = 0;
        for (Table.RawRow row : rows) {
            String newName = row.name().replace(fromUuid, toUuid);
            if (newName.equals(row.name())) continue;
            Table target = route(newName);
            if (target == null) continue;

            if (target.has(newName)) continue;
            if (target.save(newName, row.type(), row.value())) moved++;
        }
        flushAll();
        purgeUuidEverywhere(fromUuid);
        return moved;
    }

    @Override
    protected boolean requiresFile() {
        return false;
    }

    @Override
    protected File getFile(String fileName) {
        return new File(fileName);
    }

    @Override
    protected boolean load_i(SectionNode node) {

        try {
            if (!TableConfig.build(SkStoragePlugin.get(), this)) {
                Log.hard("persistence disabled (database: false); no tables built");
                return false;
            }

            File dataDir = SkStoragePlugin.get().getDataFolder();
            if (SkStoragePlugin.get().getConfig()
                    .getBoolean("experimental.automatically_delete_disabled_db_on_startup", true)) {
                File orphan = new File(dataDir, "_disabled.db");
                if (orphan.exists()) {
                    deleteDisabledDb(dataDir);
                    Log.soft("removed orphaned _disabled.db (writes made while " +
                        "the database was killed are discarded).");
                }
            }
            for (Table t : allTables()) {
                t.open();
            }
            installAcceptPattern();
            loadEverything();
            SkStoragePlugin.get().setRouter(this);
            return true;
        } catch (Exception e) {
            Log.hard("router load failed: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private void installAcceptPattern() {
        SkriptReflect.setNamePattern(this, Pattern.compile(".*"));
    }

    private void loadEverything() {
        for (Table t : allTables()) {
            t.loadAll((name, value) -> SkriptReflect.variableLoaded(name, value, this), ignoreInvalid);
        }
    }

    @Override
    protected void allLoaded() {
    }

    @Override
    protected boolean connect() {
        return true;
    }

    @Override
    protected void disconnect() {
        for (Table t : allTables()) {
            t.close();
        }
    }

    @Override
    public void close() {
        super.close();
        disconnect();
    }

    public void flushAll() {
        if (killed) {
            if (disabledTable != null) {
                try { disabledTable.flush(); } catch (Throwable ignored) {}
            }
            return;
        }
        for (Table t : allTables()) {
            try {
                t.flush();
            } catch (Throwable th) {
                Log.soft("flush failed for table " + t.name() + ": " + th.getMessage());
            }
        }
    }

    @Override
    protected boolean save(String name, @Nullable String type, byte @Nullable [] value) {
        Table target = route(name);
        if (target == null) {

            return false;
        }
        return target.save(name, type, value);
    }
}
