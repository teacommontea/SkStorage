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

package net.teacommontea.skstorage;
import net.teacommontea.skstorage.util.Log;

import ch.njol.skript.Skript;
import ch.njol.skript.variables.Variables;
import net.teacommontea.skstorage.command.SkStorageCommand;
import net.teacommontea.skstorage.math.SkNumModule;
import net.teacommontea.skstorage.playerdata.ExprPlayerData;
import net.teacommontea.skstorage.playerdata.PlayerDataListener;
import net.teacommontea.skstorage.playerdata.PlayerDataStore;
import net.teacommontea.skstorage.route.SkStorageRouter;
import net.teacommontea.skstorage.util.IpHasher;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Nullable;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "SkStorage Plugin Bootstrap",
    excerpt = "Main plugin entry point that wires up every SkStorage subsystem during server startup and shutdown.",
    dev = true,
    detail = "The JavaPlugin subclass that owns SkStorage's lifecycle. On onLoad it saves the default config, runs the ConfigUpdater prune/sync passes to remove retired keys and append missing blocks, then registers the skstorage Skript variable storage type so Skript can route variables through SkStorageRouter. On onEnable it conditionally initializes player data tracking (IpHasher plus PlayerDataStore plus PlayerDataListener plus the playerdata Skript expression), registers the exact math engine (SkNumModule) when exact_math is enabled or warns about potential variable corruption when it is not, wires the /skstorage command executor and tab completer, registers the PlotSquared and LiteBans soft-dependency hooks when present, schedules a repeating asynchronous router flush task every four ticks, kicks off a one-time CSV conversion once the router is up when convert_csv is enabled, registers the update-notify listener, and starts the asynchronous update check. On onDisable it cancels the flush task, flushes the router, and closes the player data store. Holds a static singleton accessor and exposes getters/setters for the router, player data store, and the available update version banner.",
    webEquivalent = "The application entry point and dependency-injection composition root of a web app, akin to a framework's main() or a Spring @SpringBootApplication that boots services on startup and tears them down on shutdown.",
    notes = "The static instance is set in onLoad and retrieved elsewhere via SkStoragePlugin.get(). The router is injected later by the storage layer via setRouter rather than being constructed here.",
    caveats = "The playerdata Skript expression is only registered while Skript still accepts registrations; if Skript stops accepting them early the expression is unavailable, though auto-tracking and /skstorage who continue to work. experimental.threaded_file_io is intentionally a no-op because I/O already runs off-thread."
)
public final class SkStoragePlugin extends JavaPlugin {

    private static SkStoragePlugin instance;

    @Nullable private SkStorageRouter router;
    @Nullable private PlayerDataStore playerDataStore;
    @Nullable private IpHasher ipHasher;
    @Nullable private BukkitTask flushTask;

    @Nullable private volatile String availableUpdateVersion;

    public void setAvailableUpdateVersion(@Nullable String version) {
        this.availableUpdateVersion = version;
    }

    @Nullable
    public String getAvailableUpdateVersion() {
        return availableUpdateVersion;
    }

    public static SkStoragePlugin get() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
        saveDefaultConfig();

        java.util.List<String> removed = net.teacommontea.skstorage.util.ConfigUpdater.prune(this);
        java.util.List<String> added = net.teacommontea.skstorage.util.ConfigUpdater.sync(this);
        if (!removed.isEmpty() || !added.isEmpty()) {
            reloadConfig();
            if (!removed.isEmpty()) {
                getLogger().info("Config updater removed " + removed.size() +
                    " retired key(s): " + String.join(", ", removed));
            }
            if (!added.isEmpty()) {
                getLogger().info("Config updater appended " + added.size() +
                    " missing block(s): " + String.join(", ", added));
            }
        }

        Variables.registerStorage(SkStorageRouter.class, "skstorage");
        getLogger().info("Registered Skript storage type: skstorage");
    }

    @Override
    public void onEnable() {
        boolean playerdataEnabled = getConfig().getBoolean("playerdata.enabled", true);
        if (playerdataEnabled) {
            try {
                boolean trackIpHash = getConfig().getBoolean("playerdata.track_last_ip_hash", false);
                ipHasher = new IpHasher(getDataFolder().toPath().resolve("secret.key"), trackIpHash);
                playerDataStore = new PlayerDataStore(
                    getDataFolder().toPath().resolve("playerdata.db").toString());
                getServer().getPluginManager().registerEvents(
                    new PlayerDataListener(playerDataStore, ipHasher), this);
                ExprPlayerData.setStore(playerDataStore);

                if (Skript.isAcceptRegistrations()) {
                    ExprPlayerData.register();
                    getLogger().info("Registered `playerdata` Skript expression");
                } else {
                    Log.soft("Skript stopped accepting registrations early; " +
                        "`playerdata` expression unavailable. Auto-tracking and /skstorage who still work.");
                }
                getLogger().info("Player data tracking enabled (track_last_ip_hash=" + trackIpHash + ")");
            } catch (Exception e) {
                Log.hard("Failed to initialize player data", e);
            }
        } else {
            getLogger().info("Player data tracking disabled in config.");
        }

        if (getConfig().getBoolean("exact_math", true)) {
            try {
                Skript.registerAddon(this);
                SkNumModule.register(getLogger());
            } catch (Throwable th) {
                Log.hard("Failed to register exact math engine", th);
            }
        } else {
            getLogger().warning("Math is being processed by Skript. " +
                "Variables may be inadvertently corrupted when saving.");
        }

        SkStorageCommand cmd = new SkStorageCommand(this);
        getCommand("skstorage").setExecutor(cmd);
        getCommand("skstorage").setTabCompleter(cmd);

        try {
            net.teacommontea.skstorage.plotsquared.PlotSquaredHook.registerIfEnabled();
        } catch (NoClassDefFoundError ignored) {

        }
        try {
            net.teacommontea.skstorage.litebans.LiteBansHook.registerIfEnabled();
        } catch (NoClassDefFoundError ignored) {

        }

        flushTask = getServer().getScheduler().runTaskTimerAsynchronously(this, () -> {
            SkStorageRouter r = router;
            if (r != null) {
                try {
                    r.flushAll();
                } catch (Throwable th) {
                    Log.soft("Flush failed: " + th.getMessage());
                }
            }
        }, 4L, 4L);

        if (getConfig().getBoolean("convert_csv.enabled", false)) {
            new org.bukkit.scheduler.BukkitRunnable() {
                int waited = 0;
                @Override
                public void run() {
                    if (router != null) {
                        net.teacommontea.skstorage.migrate.CsvConverter.runIfEnabled(SkStoragePlugin.this);
                        cancel();
                    } else if (++waited > 200) {
                        Log.soft("convert_csv: router never came up; skipping conversion.");
                        cancel();
                    }
                }
            }.runTaskTimer(this, 1L, 1L);
        }

        if (getConfig().getBoolean("experimental.threaded_file_io", false)) {

            getLogger().info("experimental.threaded_file_io: I/O is already off-thread " +
                "(Skript write thread + async flush); no extra I/O thread added.");
        }

        getServer().getPluginManager().registerEvents(
            new net.teacommontea.skstorage.util.UpdateNotifyListener(this), this);
        net.teacommontea.skstorage.util.UpdateChecker.checkAsync(this);

        getLogger().info("SkStorage enabled.");
    }

    @Override
    public void onDisable() {
        if (flushTask != null) {
            flushTask.cancel();
            flushTask = null;
        }
        if (router != null) {
            router.flushAll();
        }
        if (playerDataStore != null) {
            playerDataStore.close();
        }
    }

    public void setRouter(SkStorageRouter router) {
        this.router = router;
    }

    @Nullable
    public SkStorageRouter getRouter() {
        return router;
    }

    @Nullable
    public PlayerDataStore getPlayerDataStore() {
        return playerDataStore;
    }
}
