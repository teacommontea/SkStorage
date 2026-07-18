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
import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.registrations.Classes;
import net.teacommontea.skstorage.util.Log;
import net.teacommontea.skstorage.SkStoragePlugin;
import net.teacommontea.skstorage.util.BukkitItemCodec;
import net.teacommontea.skstorage.util.SqliteSetup;
import net.teacommontea.skstorage.util.StringDict;
import net.teacommontea.skstorage.util.UuidExtractor;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import net.teacommontea.skstorage.docs.Reviewed;
import net.teacommontea.skstorage.docs.Description;

@Reviewed(true)
@Description(
    title = "Table (SQLite variable store)",
    excerpt = "A single routing table backed by one or many SQLite database files, with buffered writes and optional per-UUID sharding.",
    dev = true,
    detail = "Represents one configured routing table and owns its SQLite persistence. In single-file mode the table keeps one Handle (a Connection plus a StringDict type dictionary and prepared upsert/delete statements) against its location file. In split_file_by_uuid mode the location is a directory and each row's UUID is extracted (UuidExtractor.firstUuid), hashed into a shardChars-length subdirectory, and stored in a dedicated <uuid>.db shard; open shard handles are kept in an access-ordered LinkedHashMap bounded by MAX_OPEN_HANDLES (256) with least-recently-used eviction. Writes are staged into a per-handle pending map (save) and applied in batches on flush/close/clear via drain, which commits the upsert and delete batches. The schema is a WITHOUT ROWID variables table keyed by name with an integer type_id (resolved through the StringDict) and a BLOB value; ItemStack values are intercepted and re-encoded through BukkitItemCodec. Read paths (loadAll, reloadUuid, readRowsContaining, has, rowCount) deserialize values back into Skript objects using Classes.deserialize, dropping rows whose type is unknown or fails to deserialize unless ignoreInvalid is set. Maintenance operations include purgeUuid (drop a shard file or GLOB-delete matching rows), purgeByGlob, clear, diskBytes/rowCount stats (counting -shm and -wal sidecar files), and checkpoint-truncate on close.",
    webEquivalent = "A per-tenant database shard or table with a write-behind buffer and an LRU connection pool, similar to a sharded key-value store partitioned by a tenant key.",
    notes = "split_file_by_uuid requires every variable name to contain a UUID; non-UUID names in a split table are logged as hard errors and dropped. shardChars controls how many leading UUID characters form the subdirectory name (config player.shard-chars).",
    caveats = "Writes are not durable until drain() runs on flush, close, clear, or purge; a crash before draining loses pending writes. rowCount returns -1 on SQL failure. All public operations synchronize on a single lock, so heavy concurrent access to one table serializes."
)
public final class Table {

    private static final String UPSERT =
        "INSERT INTO variables (name, type_id, value) VALUES (?, ?, ?) " +
        "ON CONFLICT(name) DO UPDATE SET type_id=excluded.type_id, value=excluded.value";
    private static final String DELETE = "DELETE FROM variables WHERE name = ?";
    private static final String SCHEMA =
        "CREATE TABLE IF NOT EXISTS variables (" +
        "  name    TEXT PRIMARY KEY," +
        "  type_id INTEGER NOT NULL," +
        "  value   BLOB" +
        ") WITHOUT ROWID";

    private final String name;
    private final boolean splitFileByUuid;
    private final boolean permanent;
    private final int index;
    private final File location;
    private final int shardChars;
    private final SqliteSetup.Options sqliteOptions;

    private final Object lock = new Object();
    private final java.util.concurrent.atomic.AtomicLong writesTotal =
        new java.util.concurrent.atomic.AtomicLong();

    @Nullable private Handle single;

    private static final int MAX_OPEN_HANDLES = 256;
    private final LinkedHashMap<String, Handle> handles =
        new LinkedHashMap<>(64, 0.75f, true);

    public Table(String name, boolean splitFileByUuid, boolean permanent, int index,
                 File location, int shardChars, SqliteSetup.Options sqliteOptions) {
        this.name = name;
        this.splitFileByUuid = splitFileByUuid;
        this.permanent = permanent;
        this.index = index;
        this.location = location;
        this.shardChars = shardChars;
        this.sqliteOptions = sqliteOptions;
    }

    public String name() { return name; }
    public boolean isSplitFileByUuid() { return splitFileByUuid; }
    public boolean isPermanent() { return permanent; }
    public int index() { return index; }

    public void open() throws SQLException {
        synchronized (lock) {
            if (splitFileByUuid) {
                if (!location.exists() && !location.mkdirs()) {
                    throw new SQLException("cannot create table directory: " + location);
                }
            } else {
                File parent = location.getParentFile();
                if (parent != null && !parent.exists()) parent.mkdirs();
                single = openHandle(location);
            }
        }
    }

    public void close() {
        synchronized (lock) {
            if (single != null) { closeHandle(single); single = null; }
            for (Handle h : handles.values()) closeHandle(h);
            handles.clear();
        }
    }

    public void flush() {
        synchronized (lock) {
            if (single != null) drain(single);
            for (Handle h : handles.values()) drain(h);
        }
    }

    public boolean save(String name, @Nullable String type, byte @Nullable [] value) {
        BukkitItemCodec.Result codec = BukkitItemCodec.intercept(name, type, value);
        synchronized (lock) {
            try {
                Handle h = handleFor(name);
                if (h == null) return false;
                h.pending.put(name, new Pending(codec.type, codec.value));
                writesTotal.incrementAndGet();
                return true;
            } catch (SQLException e) {
                Log.hard("table " + this.name + " save failed for " + name + ": " + e.getMessage());
                return false;
            }
        }
    }

    public long writesTotal() { return writesTotal.get(); }

    public int openHandles() {
        synchronized (lock) {
            return splitFileByUuid ? handles.size() : (single != null ? 1 : 0);
        }
    }

    public long diskBytes() {
        long total = 0;
        if (splitFileByUuid) {
            for (File f : shardFiles()) {
                total += sizeWithSidecars(f);
            }
        } else {
            total += sizeWithSidecars(location);
        }
        return total;
    }

    public long rowCount() {
        synchronized (lock) {
            long total = 0;
            try {
                if (splitFileByUuid) {
                    for (File f : shardFiles()) {
                        try (Connection c = SqliteSetup.open(f.getAbsolutePath(), sqliteOptions)) {
                            total += countRows(c);
                        }
                    }
                } else if (single != null && single.conn != null) {
                    total += countRows(single.conn);
                }
            } catch (SQLException e) {
                return -1;
            }
            return total;
        }
    }

    private static long countRows(Connection c) throws SQLException {
        try (Statement st = c.createStatement();
             ResultSet r = st.executeQuery("SELECT COUNT(*) FROM variables")) {
            return r.next() ? r.getLong(1) : 0;
        }
    }

    private static long sizeWithSidecars(File db) {
        long total = db.exists() ? db.length() : 0;
        File shm = new File(db.getAbsolutePath() + "-shm");
        File wal = new File(db.getAbsolutePath() + "-wal");
        if (shm.exists()) total += shm.length();
        if (wal.exists()) total += wal.length();
        return total;
    }

    public int reloadUuid(String uuid, BiConsumer<String, Object> feed, boolean ignoreInvalid) {
        if (!splitFileByUuid) return -1;
        synchronized (lock) {
            Handle open = handles.remove(uuid);
            if (open != null) closeHandle(open);
            File f = shardPath(uuid);
            if (!f.exists()) return -1;
            int[] count = {0};
            try (Handle h = openHandle(f)) {
                readRows(h, (n, v) -> { feed.accept(n, v); count[0]++; }, ignoreInvalid);
            } catch (SQLException e) {
                Log.soft("flatline reload failed for " + uuid + ": " + e.getMessage());
                return -1;
            }
            return count[0];
        }
    }

    public void loadAll(BiConsumer<String, Object> feed, boolean ignoreInvalid) {
        synchronized (lock) {
            if (splitFileByUuid) {
                List<File> files = shardFiles();
                for (File f : files) {
                    try (Handle h = openHandle(f)) {
                        readRows(h, feed, ignoreInvalid);
                    } catch (SQLException e) {
                        if (!ignoreInvalid) {
                            throw new IllegalStateException("[SkStorage] table " + name +
                                " failed to load shard " + f.getName(), e);
                        }
                        Log.soft("table " + name + " skipped unreadable shard "
                            + f.getName() + ": " + e.getMessage());
                    }
                }
            } else {
                if (single == null) return;
                try {
                    readRows(single, feed, ignoreInvalid);
                } catch (SQLException e) {
                    if (!ignoreInvalid) {
                        throw new IllegalStateException("[SkStorage] table " + name + " failed to load", e);
                    }
                    Log.soft("table " + name + " load error: " + e.getMessage());
                }
            }
        }
    }

    public record RawRow(String name, @Nullable String type, byte @Nullable [] value) {}

    public boolean has(String name) {
        synchronized (lock) {
            try {
                if (splitFileByUuid) {
                    String uuid = UuidExtractor.firstUuid(name);
                    if (uuid == null) return false;
                    File f = shardPath(uuid);
                    if (!f.exists()) return false;
                    try (Connection c = SqliteSetup.open(f.getAbsolutePath(), sqliteOptions)) {
                        return rowExists(c, name);
                    }
                } else if (single != null && single.conn != null) {
                    return rowExists(single.conn, name);
                }
            } catch (SQLException ignored) {}
            return false;
        }
    }

    private static boolean rowExists(Connection c, String name) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement("SELECT 1 FROM variables WHERE name = ? LIMIT 1")) {
            ps.setString(1, name);
            try (ResultSet r = ps.executeQuery()) {
                return r.next();
            }
        }
    }

    public List<RawRow> readRowsContaining(String needle) {
        synchronized (lock) {
            List<RawRow> out = new ArrayList<>();
            try {
                if (splitFileByUuid) {

                    File f = shardPath(needle);
                    if (f.exists()) {
                        try (Connection c = SqliteSetup.open(f.getAbsolutePath(), sqliteOptions);
                             StringDict td = new StringDict(c, "type_dict")) {
                            readRaw(c, td, needle, out);
                        }
                    }
                } else if (single != null && single.conn != null && single.typeDict != null) {
                    readRaw(single.conn, single.typeDict, needle, out);
                }
            } catch (SQLException e) {
                Log.soft("table " + name + " readRowsContaining failed: " + e.getMessage());
            }
            return out;
        }
    }

    private static void readRaw(Connection c, StringDict td, String needle, List<RawRow> out) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement(
                 "SELECT name, type_id, value FROM variables WHERE name LIKE ?")) {
            ps.setString(1, "%" + needle + "%");
            try (ResultSet r = ps.executeQuery()) {
                while (r.next()) {
                    String n = r.getString(1);
                    String type = td.get(r.getInt(2));
                    byte[] value = r.getBytes(3);
                    if (n != null) out.add(new RawRow(n, type, value));
                }
            }
        }
    }

    public int purgeUuid(String uuid) {
        synchronized (lock) {
            if (splitFileByUuid) {
                Handle open = handles.remove(uuid);
                if (open != null) closeHandle(open);
                File f = shardPath(uuid);
                int dropped = deleteDbFile(f) ? 1 : 0;
                return dropped;
            }

            return purgeByGlob("*" + uuid + "*");
        }
    }

    public int purgeByGlob(String glob) {
        synchronized (lock) {
            if (splitFileByUuid || single == null) return 0;
            drain(single);
            try (PreparedStatement ps = single.conn.prepareStatement(
                     "DELETE FROM variables WHERE name GLOB ?")) {
                ps.setString(1, glob);
                int n = ps.executeUpdate();
                single.conn.commit();
                return n;
            } catch (SQLException e) {
                Log.hard("table " + name + " purge failed for " + glob + ": " + e.getMessage());
                return 0;
            }
        }
    }

    public void clear() {
        synchronized (lock) {
            if (splitFileByUuid) {
                for (Handle h : handles.values()) closeHandle(h);
                handles.clear();
                for (File f : shardFiles()) deleteDbFile(f);
            } else if (single != null) {
                drain(single);
                try (Statement st = single.conn.createStatement()) {
                    st.execute("DELETE FROM variables");
                    single.conn.commit();
                } catch (SQLException e) {
                    Log.hard("table " + name + " clear failed: " + e.getMessage());
                }
            }
        }
    }

    @Nullable
    private Handle handleFor(String name) throws SQLException {
        if (!splitFileByUuid) return single;
        String uuid = UuidExtractor.firstUuid(name);
        if (uuid == null) {

            Log.hard("table " + this.name + " (split_file_by_uuid) got non-UUID name: " + name);
            return null;
        }
        Handle h = handles.get(uuid);
        if (h != null && h.isOpen()) return h;
        while (handles.size() >= MAX_OPEN_HANDLES) {
            var oldest = handles.entrySet().iterator().next();
            closeHandle(oldest.getValue());
            handles.remove(oldest.getKey());
        }
        h = openHandle(shardPath(uuid));
        handles.put(uuid, h);
        return h;
    }

    private Handle openHandle(File dbFile) throws SQLException {
        Connection conn = SqliteSetup.open(dbFile.getAbsolutePath(), sqliteOptions);
        try (Statement st = conn.createStatement()) {
            st.execute(SCHEMA);
        }
        Handle h = new Handle();
        h.conn = conn;
        h.typeDict = new StringDict(conn, "type_dict");
        h.upsert = conn.prepareStatement(UPSERT);
        h.delete = conn.prepareStatement(DELETE);
        conn.commit();
        return h;
    }

    private void closeHandle(Handle h) {
        drain(h);
        try { if (h.upsert != null) h.upsert.close(); } catch (SQLException ignored) {}
        try { if (h.delete != null) h.delete.close(); } catch (SQLException ignored) {}
        if (h.typeDict != null) h.typeDict.close();
        SqliteSetup.checkpointTruncate(h.conn);
        try { if (h.conn != null) h.conn.close(); } catch (SQLException ignored) {}
    }

    private void drain(Handle h) {
        if (h.conn == null || h.pending.isEmpty()) return;
        try {
            for (Map.Entry<String, Pending> e : h.pending.entrySet()) {
                Pending op = e.getValue();
                if (op.isDelete()) {
                    h.delete.setString(1, e.getKey());
                    h.delete.addBatch();
                } else {
                    int typeId = h.typeDict.getOrInsert(op.type);
                    h.upsert.setString(1, e.getKey());
                    h.upsert.setInt(2, typeId);
                    h.upsert.setBytes(3, op.value);
                    h.upsert.addBatch();
                }
            }
            h.delete.executeBatch();
            h.upsert.executeBatch();
            h.conn.commit();
            h.pending.clear();
        } catch (SQLException e) {
            h.pending.clear();
            Log.hard("table " + name + " flush failed: " + e.getMessage());
        }
    }

    private void readRows(Handle h, BiConsumer<String, Object> feed, boolean ignoreInvalid) throws SQLException {
        List<String> dead = new ArrayList<>();
        try (PreparedStatement ps = h.conn.prepareStatement("SELECT name, type_id, value FROM variables");
             ResultSet r = ps.executeQuery()) {
            while (r.next()) {
                String varName = r.getString(1);
                int typeId = r.getInt(2);
                byte[] value = r.getBytes(3);
                if (varName == null) continue;
                String typeName = h.typeDict.get(typeId);
                if (typeName == null) continue;
                if (value == null) { feed.accept(varName, null); continue; }
                if (BukkitItemCodec.TYPE_MARKER.equals(typeName)) {
                    ItemStack stack = BukkitItemCodec.decode(value);
                    ItemType it = BukkitItemCodec.toItemType(stack);
                    if (it != null) feed.accept(varName, it);
                    continue;
                }
                ClassInfo<?> ci = Classes.getClassInfoNoError(typeName);
                if (ci == null || ci.getSerializer() == null) { dead.add(varName); continue; }
                Object obj;
                try {
                    obj = Classes.deserialize(ci, value);
                } catch (Throwable t) {
                    dead.add(varName);
                    continue;
                }
                if (obj != null) feed.accept(varName, obj);
            }
        }
        if (!dead.isEmpty() && !ignoreInvalid) {

            try (PreparedStatement del = h.conn.prepareStatement(DELETE)) {
                for (String n : dead) { del.setString(1, n); del.addBatch(); }
                del.executeBatch();
                h.conn.commit();
            } catch (SQLException ignored) {}
        }
    }

    private List<File> shardFiles() {
        List<File> out = new ArrayList<>();
        if (!location.exists()) return out;
        try (java.util.stream.Stream<java.nio.file.Path> s = java.nio.file.Files.walk(location.toPath())) {
            s.filter(p -> {
                String n = p.toString();
                return n.endsWith(".db") && !n.endsWith("-shm.db") && !n.endsWith("-wal.db");
            }).forEach(p -> out.add(p.toFile()));
        } catch (java.io.IOException e) {
            Log.soft("table " + name + " could not walk shards: " + e.getMessage());
        }
        return out;
    }

    private File shardPath(String uuid) {
        String shard = uuid.substring(0, Math.min(shardChars, uuid.length()));
        File dir = new File(location, shard);
        if (!dir.exists()) dir.mkdirs();
        return new File(dir, uuid + ".db");
    }

    private boolean deleteDbFile(File f) {
        boolean deleted = f.delete();
        new File(f.getAbsolutePath() + "-shm").delete();
        new File(f.getAbsolutePath() + "-wal").delete();
        return deleted;
    }

    private static final class Handle implements AutoCloseable {
        @Nullable Connection conn;
        @Nullable StringDict typeDict;
        @Nullable PreparedStatement upsert;
        @Nullable PreparedStatement delete;
        final LinkedHashMap<String, Pending> pending = new LinkedHashMap<>();

        boolean isOpen() {
            try {
                return conn != null && !conn.isClosed();
            } catch (SQLException e) {
                return false;
            }
        }

        @Override
        public void close() {

            try { if (upsert != null) upsert.close(); } catch (SQLException ignored) {}
            try { if (delete != null) delete.close(); } catch (SQLException ignored) {}
            if (typeDict != null) typeDict.close();
            SqliteSetup.checkpointTruncate(conn);
            try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
        }
    }

    private static final class Pending {
        @Nullable final String type;
        final byte @Nullable [] value;

        Pending(@Nullable String type, byte @Nullable [] value) {
            this.type = type;
            this.value = value;
        }

        boolean isDelete() { return type == null || value == null; }
    }
}
