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

package net.teacommontea.skstorage.litebans;
import net.teacommontea.skstorage.util.Log;

import litebans.api.Database;
import litebans.api.Entry;
import litebans.api.Events;
import net.teacommontea.skstorage.SkStoragePlugin;
import net.teacommontea.skstorage.route.SkStorageRouter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "LiteBans Forget-On-Ban Hook",
    excerpt = "Purges a player's stored variables from every table when they receive a permanent LiteBans ban.",
    dev = true,
    detail = "Optional integration gated by litebans.forget_on_ban in config and the presence of the LiteBans plugin. When enabled, registers a LiteBans Events.Listener whose entryAdded callback fires on new ban records. It only acts on entries whose type is 'ban' and that are permanent; temporary bans, mutes, kicks, and warnings are ignored. For IP bans it resolves all accounts sharing that IP via LiteBans' Database.getUsersByIP (failures logged softly and tolerated); it also always includes the entry's own UUID when present. The collected UUIDs are deduplicated, then a main-thread task calls SkStorageRouter.purgeUuidEverywhere for each one, summing the units removed. A summary line is logged when anything was actually purged. Registration failures are caught and logged softly so a missing or incompatible LiteBans API never crashes startup.",
    webEquivalent = "A GDPR-style account erasure webhook that wipes all of a banned user's stored data across services when a ban event fires.",
    notes = "softdepend on LiteBans in plugin.yml. The purge runs on the main server thread to stay consistent with the router's threading expectations.",
    caveats = "Only permanent bans of type 'ban' trigger a purge; temporary or non-ban punishments do nothing. Purged variables are deleted permanently and are not recoverable if the ban is later lifted. IP-ban user resolution depends on LiteBans' database and is skipped silently if it errors."
)
public final class LiteBansHook {

    private LiteBansHook() {}

    public static void registerIfEnabled() {
        SkStoragePlugin plugin = SkStoragePlugin.get();
        if (!plugin.getConfig().getBoolean("litebans.forget_on_ban", false)) return;
        if (plugin.getServer().getPluginManager().getPlugin("LiteBans") == null) {
            plugin.getLogger().info("litebans.forget_on_ban is true but LiteBans is not loaded; skipping hook.");
            return;
        }
        try {
            Events.get().register(new Listener());
            plugin.getLogger().info("LiteBans hook installed (forget_on_ban=true).");
        } catch (Throwable t) {
            Log.soft("Failed to register LiteBans hook: " +
                t.getClass().getSimpleName() + ": " + t.getMessage());
        }
    }

    private static final class Listener extends Events.Listener {
        @Override
        public void entryAdded(Entry entry) {
            if (entry == null) return;
            if (!"ban".equals(entry.getType())) return;
            if (!entry.isPermanent()) return;

            List<String> uuids = new ArrayList<>();
            if (entry.isIpban()) {

                try {
                    Collection<String> users = Database.get().getUsersByIP(entry.getIp());
                    if (users != null) uuids.addAll(users);
                } catch (Throwable t) {
                    Log.soft(
                        "LiteBans: could not resolve IP ban users: " + t.getMessage());
                }
            }
            String single = entry.getUuid();
            if (single != null && !single.isEmpty() && !uuids.contains(single)) {
                uuids.add(single);
            }
            if (uuids.isEmpty()) return;

            SkStoragePlugin plugin = SkStoragePlugin.get();
            plugin.getServer().getScheduler().runTask(plugin, () -> {
                SkStorageRouter router = plugin.getRouter();
                if (router == null) return;
                int total = 0;
                for (String uuid : uuids) {
                    total += router.purgeUuidEverywhere(uuid);
                }
                if (total > 0) {
                    plugin.getLogger().info("forget_on_ban: purged data for " +
                        uuids.size() + " account(s) (" + total + " unit(s) removed).");
                }
            });
        }
    }
}
