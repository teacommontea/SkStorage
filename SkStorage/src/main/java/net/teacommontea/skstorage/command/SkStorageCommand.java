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

package net.teacommontea.skstorage.command;

import net.teacommontea.skstorage.SkStoragePlugin;
import net.teacommontea.skstorage.playerdata.PlayerDataStore;
import net.teacommontea.skstorage.route.SkStorageRouter;
import net.teacommontea.skstorage.route.Table;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "/skstorage admin command",
    excerpt = "The /skstorage (alias /skst) command hub that dispatches every admin subcommand and enforces per-command permissions and config toggles.",
    dev = true,
    detail = "Implements CommandExecutor and TabCompleter for the /skstorage command. onCommand validates the first argument against the known subcommand list (stats, who, clear, reload, migrate, flatline, kill, alive, merge, route), runs the permission and config gate via allowed(), then dispatches to the matching handler. allowed() checks both the plain and Privileged permission for the subcommand (or the AdminCommands umbrella): a Privileged permission bypasses all config toggles, while a plain permission still respects the commands.<sub> config value, which can be enabled, disabled, or console_only. The reload and alive subcommands are always available (ALWAYS_ON) so a misconfiguration can never soft-lock the server. Tab completion suggests subcommands and the migrate source type. The class also owns shared message-formatting color constants, a byte-size humanizer, a UUID resolver (accepting a raw UUID, a tracked name, or a cached OfflinePlayer), and short confirmation tokens used to require a second confirming invocation for destructive commands.",
    webEquivalent = "An admin CLI or dashboard route table with role-based access control, where each subcommand is an endpoint gated by a permission and a feature flag.",
    notes = "Permission names follow SkStorage.<Sub>Command and SkStorage.<Sub>CommandPrivileged, matching plugin.yml. Operators bypass permission checks. Individual subcommands are documented on their own handler methods.",
    caveats = "Config toggles only constrain holders of the plain (non-Privileged) permission; a Privileged holder or operator can always run a command regardless of the commands.<sub> setting."
)
public final class SkStorageCommand implements CommandExecutor, TabCompleter {

    public static final String PFX  = "§2[§aSkStorage§2] ";
    public static final String MSG  = "§f";
    public static final String FEAT = "§e";
    public static final String ERR  = "§c";
    public static final String ACT  = "§b";
    public static final String INFO = "§7§o";

    private static final List<String> SUBS = List.of(
        "stats", "who", "clear", "reload", "migrate",
        "flatline", "kill", "alive", "merge", "route");

    private static final java.util.Set<String> ALWAYS_ON = java.util.Set.of("reload", "alive");

    private final SkStoragePlugin plugin;

    @Nullable private String clearToken;
    @Nullable private String mergeToken;
    @Nullable private String mergePayload;

    public SkStorageCommand(SkStoragePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(PFX + MSG + "Usage: " + INFO + "/skstorage <" + String.join("|", SUBS) + ">");
            return true;
        }
        String sub = args[0].toLowerCase();
        if (!SUBS.contains(sub)) {
            sender.sendMessage(PFX + ERR + "Unknown subcommand: " + INFO + args[0]);
            return true;
        }
        if (!allowed(sender, sub)) return true;

        switch (sub) {
            case "stats"    -> stats(sender);
            case "who"      -> who(sender, args);
            case "clear"    -> clear(sender, args);
            case "reload"   -> reload(sender);
            case "migrate"  -> migrate(sender, args);
            case "flatline" -> flatline(sender, args);
            case "kill"     -> kill(sender);
            case "alive"    -> alive(sender);
            case "merge"    -> merge(sender, args);
            case "route"    -> route(sender, args);
        }
        return true;
    }

    private boolean allowed(CommandSender sender, String sub) {
        String cap = capitalize(sub);
        boolean privileged = sender.hasPermission("SkStorage." + cap + "CommandPrivileged")
            || sender.hasPermission("SkStorage.AdminCommandsPrivileged");
        boolean base = sender.hasPermission("SkStorage." + cap + "Command")
            || sender.hasPermission("SkStorage.AdminCommands");

        if (!privileged && !base) {
            sender.sendMessage(PFX + ERR + "You don't have permission to use " + INFO + sub + ERR + ".");
            return false;
        }

        if (privileged) return true;

        if (ALWAYS_ON.contains(sub)) return true;

        String mode = plugin.getConfig().getString("commands." + sub, "enabled").toLowerCase();
        switch (mode) {
            case "disabled":
                sender.sendMessage(PFX + ERR + "The " + INFO + sub + ERR + " command is disabled in config.yml.");
                return false;
            case "console_only":
                if (!(sender instanceof ConsoleCommandSender)) {
                    sender.sendMessage(PFX + ERR + "The " + INFO + sub + ERR + " command is console-only.");
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private static String capitalize(String s) {
        return s.isEmpty() ? s : Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    private SkStorageRouter router(CommandSender sender) {
        SkStorageRouter r = plugin.getRouter();
        if (r == null) {
            sender.sendMessage(PFX + ERR + "Router not loaded. Is the 'skstorage' database registered in Skript?");
        }
        return r;
    }

    @Description(
        title = "/skstorage stats",
        excerpt = "Shows how much storage each table is using and how busy it is.",
        dev = false,
        detail = "Prints a summary of every storage table: how many entries it holds, how much disk space it takes up, how many files it currently has open, and how many saves it has handled since the server started. A grand total is shown at the bottom. If storage has been temporarily shut off, the header is marked so you know the numbers reflect a paused state.",
        webEquivalent = "A database status or usage dashboard showing per-table row counts and storage size.",
        notes = "Useful for spotting a table that is growing unusually large or being written to very heavily."
    )
    private void stats(CommandSender sender) {
        SkStorageRouter r = router(sender);
        if (r == null) return;
        sender.sendMessage(PFX + FEAT + "Storage strain" + (r.isKilled() ? ERR + " (KILLED)" : "") + MSG + ":");
        long totalBytes = 0, totalRows = 0, totalWrites = 0;
        for (Table t : r.allTables()) {
            long bytes = t.diskBytes();
            long rows = t.rowCount();
            long writes = t.writesTotal();
            totalBytes += bytes;
            if (rows > 0) totalRows += rows;
            totalWrites += writes;
            sender.sendMessage(PFX + MSG + " " + INFO + t.name() + MSG +
                ": " + rows + " rows, " + human(bytes) + ", " +
                t.openHandles() + " handle(s), " + writes + " writes");
        }
        sender.sendMessage(PFX + FEAT + "Total" + MSG + ": " + totalRows + " rows, " +
            human(totalBytes) + ", " + totalWrites + " writes this session");
    }

    @Description(
        title = "/skstorage who",
        excerpt = "Looks up the tracked history of a player by name or unique ID.",
        dev = false,
        detail = "Given a player name or unique ID, shows what is known about that player: their current name and ID, when they first joined, when they last joined and last left, their total playtime and number of sessions, the last world they were in, and a privacy-preserving hash of their last IP. If you type only part of a name, up to five possible matches are listed so you can pick the right one.",
        webEquivalent = "A user profile or account lookup page in an admin panel.",
        notes = "Requires player data tracking to be turned on. The IP is only ever shown as a hash, never as a real address.",
        caveats = "Only players who have joined since tracking was enabled will have a record."
    )
    private void who(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(PFX + MSG + "Usage: " + INFO + "/skstorage who <player>");
            return;
        }
        PlayerDataStore store = plugin.getPlayerDataStore();
        if (store == null) {
            sender.sendMessage(PFX + ERR + "Player data tracking is disabled.");
            return;
        }
        String query = args[1];
        UUID uuid = store.lookupUuid(query);
        if (uuid == null) {
            List<PlayerDataStore.NameMatch> matches = store.searchByPartialName(query, 5);
            if (matches.isEmpty()) {
                sender.sendMessage(PFX + ERR + "No tracked player matching " + INFO + query);
                return;
            }
            if (matches.size() > 1) {
                sender.sendMessage(PFX + FEAT + "Multiple matches:");
                for (PlayerDataStore.NameMatch m : matches) {
                    sender.sendMessage(PFX + MSG + " " + INFO + m.name() + MSG + " (" + m.uuid() + ")");
                }
                return;
            }
            uuid = matches.get(0).uuid();
        }
        PlayerDataStore.PlayerRecord rec = store.get(uuid);
        if (rec == null) {
            sender.sendMessage(PFX + ERR + "No record for " + INFO + uuid);
            return;
        }
        sender.sendMessage(PFX + FEAT + "Player: " + INFO + rec.name() + MSG + " (" + rec.uuid() + ")");
        sender.sendMessage(PFX + MSG + " First join: " + INFO + new Date(rec.firstJoin()));
        sender.sendMessage(PFX + MSG + " Last join:  " + INFO + new Date(rec.lastJoin()));
        if (rec.lastQuit() != null) sender.sendMessage(PFX + MSG + " Last quit:  " + INFO + new Date(rec.lastQuit()));
        sender.sendMessage(PFX + MSG + " Playtime:   " + INFO + (rec.totalPlaytime() / 60000) + " min, " +
            rec.totalSessions() + " sessions");
        if (rec.lastWorld() != null) sender.sendMessage(PFX + MSG + " Last world: " + INFO + rec.lastWorld());
        if (rec.lastIpHash() != null) sender.sendMessage(PFX + MSG + " IP hash:    " + INFO + rec.lastIpHash());
    }

    @Description(
        title = "/skstorage clear",
        excerpt = "Wipes every non-permanent storage table after a confirmation step.",
        dev = false,
        detail = "Erases all data held in tables that are not marked permanent. Permanent tables and the fallback default storage are left untouched. Because this is destructive, running it once gives you a one-time confirmation code; you must run the command again with that code to actually wipe the data. It reports how many tables were cleared.",
        webEquivalent = "A bulk delete or reset action guarded by a type-to-confirm prompt.",
        notes = "Whether a table survives this command is set by its permanent option in the config.",
        caveats = "The wipe cannot be undone once confirmed. Back up your data first if you are unsure."
    )
    private void clear(CommandSender sender, String[] args) {
        SkStorageRouter r = router(sender);
        if (r == null) return;
        if (args.length >= 2 && args[1].equals(clearToken) && clearToken != null) {
            int wiped = 0;
            for (Table t : r.allTables()) {
                if (!t.isPermanent()) { t.clear(); wiped++; }
            }
            clearToken = null;
            sender.sendMessage(PFX + ACT + "Cleared " + INFO + wiped + MSG + " non-permanent table(s). " +
                "Permanent tables and default.db were spared.");
            return;
        }
        clearToken = shortToken();
        sender.sendMessage(PFX + ERR + "This wipes every non-permanent table. To confirm:");
        sender.sendMessage(PFX + INFO + "/skstorage clear " + clearToken);
    }

    @Description(
        title = "/skstorage reload",
        excerpt = "Reloads the plugin's configuration file without restarting.",
        dev = false,
        detail = "Re-reads the config.yml settings so tweaks take effect without restarting the server. Note that adding, removing, or changing tables and databases still needs a full server restart; this only refreshes the plain settings.",
        webEquivalent = "A reload-config button that re-applies settings from a config file at runtime.",
        notes = "This command is always available even if other commands are disabled, so a bad config can always be corrected and reloaded."
    )
    private void reload(CommandSender sender) {
        plugin.reloadConfig();
        sender.sendMessage(PFX + ACT + "Reloaded " + INFO + "config.yml" + MSG +
            ". Table/database changes still require a full restart.");
    }

    @Description(
        title = "/skstorage migrate",
        excerpt = "Imports Skript variables from an older PatPeter SQLibrary database into SkStorage.",
        dev = false,
        detail = "Brings your existing Skript variables over from a database created by the older PatPeter SQLibrary storage system. You point it at the old database file. By default it runs as a safe preview that shows what would be imported without changing anything; adding the confirmation flag performs the real import after you have made a backup.",
        webEquivalent = "A data import wizard with a dry-run preview before committing.",
        notes = "Usage: /skstorage migrate sqlibrary <path> [--i-have-backed-up]. Without the flag it only previews.",
        caveats = "Always back up your data before running the real import; the confirmation flag exists to make sure you have."
    )
    private void migrate(CommandSender sender, String[] args) {
        if (args.length < 3 || !"sqlibrary".equalsIgnoreCase(args[1])) {
            sender.sendMessage(PFX + MSG + "Usage: " + INFO +
                "/skstorage migrate sqlibrary <path> [--i-have-backed-up]");
            return;
        }
        java.io.File source = new java.io.File(args[2]);
        if (!source.exists()) {
            sender.sendMessage(PFX + ERR + "Source not found: " + INFO + source.getAbsolutePath());
            return;
        }
        boolean live = args.length >= 4 && "--i-have-backed-up".equalsIgnoreCase(args[3]);
        try {
            new net.teacommontea.skstorage.migrate.SqlibraryMigrator(plugin).migrate(source, sender, !live);
        } catch (java.sql.SQLException e) {
            sender.sendMessage(PFX + ERR + "Migration error: " + INFO + e.getMessage());
        }
    }

    @Description(
        title = "/skstorage flatline",
        excerpt = "Force-reloads a single player's saved data straight from disk.",
        dev = false,
        detail = "Reloads one player's stored variables from disk, given their name or unique ID. This is useful if a player's data was changed directly on disk, or got out of sync, and you want the server to pick up the on-disk version again without restarting. It reports how many of that player's variables were reloaded.",
        webEquivalent = "A per-record cache refresh that re-reads a single user's data from the source of truth.",
        notes = "Only applies to tables that store each player in their own file (UUID-split tables).",
        caveats = "Has no effect for a player who has no data in any per-player split table."
    )
    private void flatline(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(PFX + MSG + "Usage: " + INFO + "/skstorage flatline <player|uuid>");
            return;
        }
        SkStorageRouter r = router(sender);
        if (r == null) return;
        UUID uuid = resolveUuid(args[1]);
        if (uuid == null) {
            sender.sendMessage(PFX + ERR + "Could not resolve " + INFO + args[1] + ERR + " to a UUID.");
            return;
        }
        int totalReloaded = 0;
        boolean anyShard = false;
        for (Table t : r.allTables()) {
            if (!t.isSplitFileByUuid()) continue;
            int n = t.reloadUuid(uuid.toString(),
                (name, value) -> net.teacommontea.skstorage.util.SkriptReflect.variableLoaded(name, value, r),
                true);
            if (n >= 0) { anyShard = true; totalReloaded += n; }
        }
        if (!anyShard) {
            sender.sendMessage(PFX + ERR + "No sharded table holds data for " + INFO + uuid);
            return;
        }
        sender.sendMessage(PFX + ACT + "Flatline: reloaded " + INFO + totalReloaded +
            MSG + " variable(s) for " + INFO + uuid + MSG + " from disk.");
    }

    @Description(
        title = "/skstorage kill",
        excerpt = "Safely pauses the storage system so you can reload other plugins without a restart.",
        dev = false,
        detail = "Temporarily shuts down the storage system: all real data is saved and its files are closed, then the plugin quietly diverts any further saves to a throwaway file. This lets you reload or update other plugins that touch the same files without stopping the server. Anything written while paused is discarded when you bring storage back with /skstorage alive.",
        webEquivalent = "Putting a service into maintenance mode so its files can be safely touched.",
        notes = "Console-only by default. Use /skstorage alive to resume. Data saved before the kill is safe.",
        caveats = "Variables changed while storage is killed are thrown away on revival by design; do not rely on saves made during this window."
    )
    private void kill(CommandSender sender) {
        SkStorageRouter r = router(sender);
        if (r == null) return;
        if (r.isKilled()) {
            sender.sendMessage(PFX + ERR + "Database is already killed. Use " + INFO + "/skstorage alive" + ERR + ".");
            return;
        }
        r.kill(plugin.getDataFolder());
        sender.sendMessage(PFX + ACT + "Database killed. Real tables flushed and closed; writes now go to " +
            INFO + "_disabled.db" + MSG + " and are discarded on revival. Safe to reload other plugins.");
    }

    @Description(
        title = "/skstorage alive",
        excerpt = "Resumes the storage system after it was paused with /skstorage kill.",
        dev = false,
        detail = "Brings storage back online after a /skstorage kill. The real data files are reopened and saving returns to normal. The temporary throwaway file used while paused is deleted (unless you have turned that cleanup off in the config), so anything written during the pause is discarded.",
        webEquivalent = "Taking a service out of maintenance mode and restoring normal operation.",
        notes = "Console-only by default. This command is always available so you can never get stuck in the killed state."
    )
    private void alive(CommandSender sender) {
        SkStorageRouter r = router(sender);
        if (r == null) return;
        if (!r.isKilled()) {
            sender.sendMessage(PFX + ERR + "Database is not killed.");
            return;
        }
        boolean del = plugin.getConfig().getBoolean("experimental.automatically_delete_disabled_db_on_startup", true);
        r.revive(plugin.getDataFolder(), del);
        sender.sendMessage(PFX + ACT + "Database revived. Real tables reopened" +
            (del ? "; _disabled.db deleted." : "; _disabled.db kept (toggle off)."));
    }

    @Description(
        title = "/skstorage merge",
        excerpt = "Combines one player's stored data into another player's, then removes the source.",
        dev = false,
        detail = "Moves all of one player's saved variables onto another player, which is handy when someone's account identity changed and you want to carry their data over. You give a from player and a to player (by name or unique ID). Where both players already have the same piece of data, the destination player's version is kept. Because this deletes the source afterward, it asks for a one-time confirmation code that you must re-enter to proceed. It reports how many variables were moved.",
        webEquivalent = "An account merge tool that reassigns records from one account to another and deletes the old one.",
        notes = "You cannot merge a player into themselves.",
        caveats = "Destructive: the source player's data is deleted after the merge, and conflicts are always resolved in favor of the destination."
    )
    private void merge(CommandSender sender, String[] args) {
        SkStorageRouter r = router(sender);
        if (r == null) return;

        if (args.length == 2 && args[1].equals(mergeToken) && mergePayload != null) {
            String[] p = mergePayload.split(" ");
            int moved = r.mergeUuid(p[0], p[1]);
            sender.sendMessage(PFX + ACT + "Merged " + INFO + moved + MSG + " variable(s) from " +
                INFO + p[0] + MSG + " into " + INFO + p[1] + MSG + "; source purged.");
            mergeToken = null;
            mergePayload = null;
            return;
        }
        if (args.length < 3) {
            sender.sendMessage(PFX + MSG + "Usage: " + INFO + "/skstorage merge <from> <to>");
            return;
        }
        UUID from = resolveUuid(args[1]);
        UUID to = resolveUuid(args[2]);
        if (from == null || to == null) {
            sender.sendMessage(PFX + ERR + "Could not resolve both players to UUIDs.");
            return;
        }
        if (from.equals(to)) {
            sender.sendMessage(PFX + ERR + "Cannot merge a player into themselves.");
            return;
        }
        mergePayload = from + " " + to;
        mergeToken = shortToken();
        sender.sendMessage(PFX + ERR + "Merge pours " + INFO + from + ERR + " into " + INFO + to + ERR +
            " (target wins collisions), then purges the source. To confirm:");
        sender.sendMessage(PFX + INFO + "/skstorage merge " + mergeToken);
    }

    @Description(
        title = "/skstorage route",
        excerpt = "Shows which storage table a given variable name would be saved to, without saving anything.",
        dev = false,
        detail = "A troubleshooting tool for your table setup. You type a variable name and it tells you which table that variable would be stored in, which pattern matched it (and that pattern's priority), or a note explaining why it fell back to the default. Nothing is actually saved; it only explains the decision, which is helpful when checking that your patterns route variables the way you intended.",
        webEquivalent = "A routing or rule tester that shows which rule a request matches without executing it.",
        notes = "The variable name can contain spaces; everything after the subcommand is treated as the name."
    )
    private void route(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(PFX + MSG + "Usage: " + INFO + "/skstorage route <variable name>");
            return;
        }
        SkStorageRouter r = router(sender);
        if (r == null) return;
        String name = String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length));
        SkStorageRouter.Explain ex = r.routeExplain(name);
        sender.sendMessage(PFX + FEAT + "Route for " + INFO + name + MSG + ":");
        sender.sendMessage(PFX + MSG + " -> table " + INFO + ex.table());
        if (ex.pattern() != null) {
            sender.sendMessage(PFX + MSG + " matched pattern " + INFO + ex.pattern() +
                MSG + " (index " + ex.index() + ")");
        }
        if (ex.note() != null) {
            sender.sendMessage(PFX + INFO + " " + ex.note());
        }
    }

    @Nullable
    private UUID resolveUuid(String s) {
        try {
            return UUID.fromString(s);
        } catch (IllegalArgumentException ignored) {

            PlayerDataStore store = plugin.getPlayerDataStore();
            if (store != null) {
                UUID u = store.lookupUuid(s);
                if (u != null) return u;
            }
            org.bukkit.OfflinePlayer op = plugin.getServer().getOfflinePlayerIfCached(s);
            return op != null ? op.getUniqueId() : null;
        }
    }

    private static String shortToken() {

        long n = System.nanoTime();
        return Long.toHexString(n & 0xFFFFFFL);
    }

    private static String human(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
    }

    @Override
    @Nullable
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> out = new ArrayList<>();
            for (String s : SUBS) {
                if (s.startsWith(args[0].toLowerCase())) out.add(s);
            }
            return out;
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("migrate")) {
            return List.of("sqlibrary");
        }
        return List.of();
    }
}
