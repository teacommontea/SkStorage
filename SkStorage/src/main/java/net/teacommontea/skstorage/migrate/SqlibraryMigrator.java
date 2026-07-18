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
import net.teacommontea.skstorage.command.SkStorageCommand;
import net.teacommontea.skstorage.route.SkStorageRouter;
import net.teacommontea.skstorage.route.Table;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "SQLibrary Migrator",
    excerpt = "Imports a legacy PatPeter SQLibrary variables21 table into SkStorage's routed tables.",
    dev = true,
    detail = "Backs the /skstorage migrate command. Opens the supplied SQLite source file directly via a jdbc:sqlite connection and reads the legacy variables21 table (columns name, type, value). Supports two modes. Dry-run scans every row, lowercases each variable name with Locale.ENGLISH, routes it through SkStorageRouter.route, and reports how many rows would land in each destination table (or UNROUTED when no table matches) without writing anything. Live mode runs asynchronously on a BukkitRunnable, guarded by a static AtomicBoolean so only one migration can run at a time; it routes and saves each row through Table.save, tallies written and skipped counts, emits a throughput update (rows/sec) every 10000 written rows, and on completion schedules SkStorageRouter.flushAll on the main thread. Rows with a null name, no matching table, or a failed save are skipped. Player-facing progress and result messages are always dispatched back onto the main thread via tell. A server restart is recommended after a live run so file handles close cleanly.",
    webEquivalent = "A one-off database import / ETL job, similar to a Rails db:migrate data backfill or a mysqldump-to-new-schema import.",
    notes = "Requires the 'skstorage' database to be registered in Skript so the router is available; otherwise the migration aborts early. The RUNNING flag is static, so the single-migration lock is process-wide.",
    caveats = "Reads exclusively from a table literally named variables21; other legacy schemas are not supported. Skipped rows are counted but not individually reported in live mode. Because the source file is opened with a raw JDBC connection, it is not deleted or closed by SkStorage's own connection pool, hence the restart recommendation."
)
public final class SqlibraryMigrator {

    private static final String PFX  = SkStorageCommand.PFX;
    private static final String MSG  = SkStorageCommand.MSG;
    private static final String FEAT = SkStorageCommand.FEAT;
    private static final String ERR  = SkStorageCommand.ERR;
    private static final String ACT  = SkStorageCommand.ACT;
    private static final String INFO = SkStorageCommand.INFO;

    private static final AtomicBoolean RUNNING = new AtomicBoolean(false);

    private final SkStoragePlugin plugin;

    public SqlibraryMigrator(SkStoragePlugin plugin) {
        this.plugin = plugin;
    }

    public void migrate(File source, CommandSender sender, boolean dryRun) throws SQLException {
        sender.sendMessage(PFX + FEAT + "SQLibrary migration " +
            (dryRun ? INFO + "(dry-run)" : ERR + "(LIVE, async)"));
        sender.sendMessage(PFX + FEAT + "Source: " + INFO + source.getAbsolutePath());

        SkStorageRouter router = plugin.getRouter();
        if (router == null) {
            sender.sendMessage(PFX + ERR + "Router not loaded; is the 'skstorage' database registered in Skript?");
            return;
        }

        if (dryRun) {
            runDryRun(source, sender, router);
            return;
        }
        if (!RUNNING.compareAndSet(false, true)) {
            sender.sendMessage(PFX + ERR + "A migration is already running.");
            return;
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    runLive(source, sender, router);
                } catch (Exception e) {
                    tell(sender, PFX + ERR + "Migration failed: " + INFO + e.getMessage());
                    Log.hard("Migration crashed: " + e);
                } finally {
                    RUNNING.set(false);
                }
            }
        }.runTaskAsynchronously(plugin);
    }

    private void runDryRun(File source, CommandSender sender, SkStorageRouter router) throws SQLException {
        Map<String, Long> counts = new HashMap<>();
        long total = 0;
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + source.getAbsolutePath());
             PreparedStatement ps = conn.prepareStatement("SELECT name, type, value FROM variables21");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                total++;
                String name = rs.getString(1);
                if (name == null) continue;
                Table t = router.route(name.toLowerCase(Locale.ENGLISH));
                counts.merge(t != null ? t.name() : "UNROUTED", 1L, Long::sum);
            }
        }
        sender.sendMessage(PFX + FEAT + "Total rows scanned: " + INFO + total);
        for (var e : counts.entrySet()) {
            sender.sendMessage(PFX + FEAT + "-> " + e.getKey() + ": " + INFO + e.getValue() + " rows");
        }
    }

    private void runLive(File source, CommandSender sender, SkStorageRouter router) throws SQLException {
        long total = 0, written = 0, skipped = 0;
        long t0 = System.currentTimeMillis();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + source.getAbsolutePath());
             PreparedStatement ps = conn.prepareStatement(
                 "SELECT name, type, value FROM variables21 ORDER BY name");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                total++;
                String name = rs.getString(1);
                String type = rs.getString(2);
                byte[] value = rs.getBytes(3);
                if (name == null) { skipped++; continue; }
                String lower = name.toLowerCase(Locale.ENGLISH);
                Table t = router.route(lower);
                if (t == null || !t.save(lower, type, value)) { skipped++; continue; }
                written++;
                if (written % 10000 == 0) {
                    long rate = rate(written, t0);
                    tell(sender, PFX + ACT + "Migrated " + INFO + written + MSG + " rows (" + rate + " rows/sec)");
                }
            }
        }

        SkStorageRouter r = router;
        plugin.getServer().getScheduler().runTask(plugin, r::flushAll);

        long elapsed = System.currentTimeMillis() - t0;
        tell(sender, PFX + FEAT + "Migration complete. Written: §a" + written +
            MSG + ", skipped: " + ERR + skipped + MSG + ", " + (elapsed / 1000L) + "s");
        tell(sender, PFX + MSG + "Recommended: restart the server so file handles close cleanly.");
    }

    private static long rate(long written, long t0) {
        long elapsed = System.currentTimeMillis() - t0;
        return elapsed > 0 ? (written * 1000L / elapsed) : 0;
    }

    private void tell(CommandSender sender, String msg) {
        Bukkit.getScheduler().runTask(plugin, () -> sender.sendMessage(msg));
    }
}
