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

package net.teacommontea.skstorage.playerdata;

import net.teacommontea.skstorage.util.SqliteSetup;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "Player metadata store",
    excerpt = "SQLite-backed tracker for per-player metadata: first/last join, playtime, session count, last world, name history, hashed last IP, and cached head textures.",
    dev = true,
    detail = "Owns a dedicated SQLite database with two WITHOUT ROWID tables: players (keyed by UUID) and name_history (keyed by UUID+name). ensureSchema creates the tables and indexes and additively migrates newer columns (head_textures, head_signature, head_cached_at) via tolerant ALTER TABLE statements that ignore duplicate-column errors, so older databases upgrade in place. recordJoin upserts the player row (updating name and last_join, incrementing total_sessions, and coalescing the last IP hash) and records the current name in name_history. recordQuit updates last_quit, adds the session duration to total_playtime, and stores the last world. get returns a PlayerRecord snapshot; lookupUuid resolves an exact name (case-insensitive) to a UUID; searchByPartialName returns NameMatch results for a case-insensitive name prefix across name history (for tab completion and fuzzy /who lookups). cacheHeadTextures/getHeadTextures persist and read a player's base64 skin texture value, signature, and cache timestamp so player heads can be rendered without a live Mojang lookup. All mutating and reading methods are synchronized and swallow SQL errors to avoid disrupting gameplay, and close() checkpoint-truncates the WAL before closing.",
    webEquivalent = "A users table plus an audit/history table in a web app's database, similar to tracking sign-up date, last-seen, session count, and a username-change log, with a cached avatar blob.",
    notes = "Backs the /skstorage who command and playerdata features (config playerdata.enabled). The last IP is stored only as a hash, never in plaintext. Playtime and timestamps are epoch milliseconds.",
    caveats = "SQL failures are silently ignored (methods return null or no-op), so a corrupt or locked database degrades gracefully rather than surfacing errors. total_playtime accuracy depends on recordQuit being called with a correct session duration; a crash or kick that skips the quit event loses that session's playtime."
)
public final class PlayerDataStore {

    private final Connection conn;
    private final PreparedStatement upsertPlayer;
    private final PreparedStatement updateQuit;
    private final PreparedStatement insertNameHistory;
    private final PreparedStatement selectPlayer;
    private final PreparedStatement selectByName;

    public PlayerDataStore(String dbPath) throws SQLException {
        this.conn = SqliteSetup.open(dbPath);
        ensureSchema();
        upsertPlayer = conn.prepareStatement(
            "INSERT INTO players (uuid, name, first_join, last_join, total_sessions, last_ip_hash) " +
            "VALUES (?, ?, ?, ?, 1, ?) " +
            "ON CONFLICT(uuid) DO UPDATE SET " +
            "  name = excluded.name, " +
            "  last_join = excluded.last_join, " +
            "  total_sessions = total_sessions + 1, " +
            "  last_ip_hash = COALESCE(excluded.last_ip_hash, last_ip_hash)"
        );
        updateQuit = conn.prepareStatement(
            "UPDATE players SET last_quit = ?, total_playtime = total_playtime + ?, last_world = ? WHERE uuid = ?"
        );
        insertNameHistory = conn.prepareStatement(
            "INSERT OR IGNORE INTO name_history (uuid, name, seen_at) VALUES (?, ?, ?)"
        );
        selectPlayer = conn.prepareStatement(
            "SELECT name, first_join, last_join, last_quit, total_playtime, total_sessions, last_world, last_ip_hash " +
            "FROM players WHERE uuid = ?"
        );
        selectByName = conn.prepareStatement(
            "SELECT uuid FROM players WHERE name = ? COLLATE NOCASE LIMIT 1"
        );
    }

    private void ensureSchema() throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute(
                "CREATE TABLE IF NOT EXISTS players (" +
                "  uuid           TEXT PRIMARY KEY," +
                "  name           TEXT NOT NULL," +
                "  first_join     INTEGER NOT NULL," +
                "  last_join      INTEGER NOT NULL," +
                "  last_quit      INTEGER," +
                "  total_playtime INTEGER NOT NULL DEFAULT 0," +
                "  total_sessions INTEGER NOT NULL DEFAULT 0," +
                "  last_world     TEXT," +
                "  last_ip_hash   TEXT," +
                "  head_textures  TEXT," +
                "  head_signature TEXT," +
                "  head_cached_at INTEGER" +
                ") WITHOUT ROWID"
            );
            st.execute(
                "CREATE TABLE IF NOT EXISTS name_history (" +
                "  uuid     TEXT NOT NULL," +
                "  name     TEXT NOT NULL," +
                "  seen_at  INTEGER NOT NULL," +
                "  PRIMARY KEY (uuid, name)" +
                ") WITHOUT ROWID"
            );
            st.execute("CREATE INDEX IF NOT EXISTS idx_players_name ON players(name)");
            st.execute("CREATE INDEX IF NOT EXISTS idx_history_name ON name_history(name)");

            tryAddColumn(st, "ALTER TABLE players ADD COLUMN head_textures TEXT");
            tryAddColumn(st, "ALTER TABLE players ADD COLUMN head_signature TEXT");
            tryAddColumn(st, "ALTER TABLE players ADD COLUMN head_cached_at INTEGER");
        }
    }

    private static void tryAddColumn(Statement st, String sql) {
        try {
            st.execute(sql);
        } catch (SQLException e) {
            String msg = e.getMessage();
            if (msg != null && msg.contains("duplicate column")) return;

        }
    }

    public synchronized void recordJoin(UUID uuid, String name, long joinMs, @Nullable String ipHash) {
        try {
            upsertPlayer.setString(1, uuid.toString());
            upsertPlayer.setString(2, name);
            upsertPlayer.setLong(3, joinMs);
            upsertPlayer.setLong(4, joinMs);
            if (ipHash == null) upsertPlayer.setNull(5, java.sql.Types.VARCHAR);
            else upsertPlayer.setString(5, ipHash);
            upsertPlayer.executeUpdate();

            insertNameHistory.setString(1, uuid.toString());
            insertNameHistory.setString(2, name);
            insertNameHistory.setLong(3, joinMs);
            insertNameHistory.executeUpdate();
        } catch (SQLException ignored) {

        }
    }

    public synchronized void recordQuit(UUID uuid, long quitMs, long sessionDurationMs, @Nullable String world) {
        try {
            updateQuit.setLong(1, quitMs);
            updateQuit.setLong(2, sessionDurationMs);
            if (world == null) updateQuit.setNull(3, java.sql.Types.VARCHAR);
            else updateQuit.setString(3, world);
            updateQuit.setString(4, uuid.toString());
            updateQuit.executeUpdate();
        } catch (SQLException ignored) {}
    }

    @Nullable
    public synchronized PlayerRecord get(UUID uuid) {
        try {
            selectPlayer.setString(1, uuid.toString());
            try (ResultSet rs = selectPlayer.executeQuery()) {
                if (!rs.next()) return null;
                Long lastQuit = rs.getLong("last_quit");
                if (rs.wasNull()) lastQuit = null;
                return new PlayerRecord(
                    uuid,
                    rs.getString("name"),
                    rs.getLong("first_join"),
                    rs.getLong("last_join"),
                    lastQuit,
                    rs.getLong("total_playtime"),
                    rs.getInt("total_sessions"),
                    rs.getString("last_world"),
                    rs.getString("last_ip_hash")
                );
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public synchronized void cacheHeadTextures(UUID uuid, String texturesValue, @Nullable String signature) {
        try (PreparedStatement ps = conn.prepareStatement(
                 "UPDATE players SET head_textures = ?, head_signature = ?, head_cached_at = ? WHERE uuid = ?")) {
            ps.setString(1, texturesValue);
            if (signature == null) ps.setNull(2, java.sql.Types.VARCHAR);
            else ps.setString(2, signature);
            ps.setLong(3, System.currentTimeMillis());
            ps.setString(4, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException ignored) {}
    }

    @Nullable
    public synchronized HeadTextures getHeadTextures(UUID uuid) {
        try (PreparedStatement ps = conn.prepareStatement(
                 "SELECT head_textures, head_signature, head_cached_at FROM players WHERE uuid = ?")) {
            ps.setString(1, uuid.toString());
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                String tx = rs.getString(1);
                if (tx == null) return null;
                return new HeadTextures(tx, rs.getString(2), rs.getLong(3));
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public record HeadTextures(String value, @Nullable String signature, long cachedAt) {}

    @Nullable
    public synchronized UUID lookupUuid(String name) {
        try {
            selectByName.setString(1, name);
            try (ResultSet rs = selectByName.executeQuery()) {
                if (!rs.next()) return null;
                return UUID.fromString(rs.getString(1));
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public synchronized java.util.List<NameMatch> searchByPartialName(String prefix, int limit) {
        java.util.List<NameMatch> out = new java.util.ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT DISTINCT name, uuid FROM name_history WHERE name LIKE ? COLLATE NOCASE LIMIT ?")) {
            ps.setString(1, prefix + "%");
            ps.setInt(2, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    out.add(new NameMatch(rs.getString(1), UUID.fromString(rs.getString(2))));
                }
            }
        } catch (SQLException ignored) {}
        return out;
    }

    public record NameMatch(String name, UUID uuid) {}

    public void close() {
        try { upsertPlayer.close(); } catch (SQLException ignored) {}
        try { updateQuit.close(); } catch (SQLException ignored) {}
        try { insertNameHistory.close(); } catch (SQLException ignored) {}
        try { selectPlayer.close(); } catch (SQLException ignored) {}
        try { selectByName.close(); } catch (SQLException ignored) {}
        net.teacommontea.skstorage.util.SqliteSetup.checkpointTruncate(conn);
        try { conn.close(); } catch (SQLException ignored) {}
    }

    public record PlayerRecord(
        UUID uuid,
        String name,
        long firstJoin,
        long lastJoin,
        @Nullable Long lastQuit,
        long totalPlaytime,
        int totalSessions,
        @Nullable String lastWorld,
        @Nullable String lastIpHash
    ) {}
}
