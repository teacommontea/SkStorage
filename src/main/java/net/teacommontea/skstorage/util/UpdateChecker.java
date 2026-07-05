package net.teacommontea.skstorage.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.teacommontea.skstorage.SkStoragePlugin;

public final class UpdateChecker {

    private static final String LATEST_RELEASE_API =
        "https://api.github.com/repos/mstrjk/SkStorage/releases/latest";

    private static final String SPIGOT_URL =
        "https://www.spigotmc.org/resources/skstorage.135767/";

    private static final Pattern VERSION = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)");

    private static final Pattern TAG_NAME = Pattern.compile("\"tag_name\"\\s*:\\s*\"([^\"]+)\"");

    private UpdateChecker() {}

    public static void checkAsync(SkStoragePlugin plugin) {
        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, () -> run(plugin));
    }

    private static void run(SkStoragePlugin plugin) {
        String localRaw = plugin.getDescription().getVersion();
        int[] local = parse(localRaw);
        if (local == null) {
            return;
        }

        String body = fetch();
        if (body == null) {
            return;
        }

        Matcher tag = TAG_NAME.matcher(body);
        if (!tag.find()) {
            return;
        }
        String remoteRaw = tag.group(1);
        int[] remote = parse(remoteRaw);
        if (remote == null) {
            return;
        }

        if (isNewer(remote, local)) {
            String version = remoteRaw.replaceFirst("^[vV]", "");
            plugin.setAvailableUpdateVersion(version);
            plugin.getLogger().warning(
                "A new version of SkStorage is available: " + version +
                ". Download at " + SPIGOT_URL + ".");
        }
    }

    public static String spigotUrl() {
        return SPIGOT_URL;
    }

    private static String fetch() {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL(LATEST_RELEASE_API).openConnection();
            conn.setRequestProperty("Accept", "application/vnd.github+json");
            conn.setRequestProperty("User-Agent", "SkStorage-UpdateChecker");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            if (conn.getResponseCode() != 200) {
                return null;
            }
            try (InputStream in = conn.getInputStream()) {
                return new String(in.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static int[] parse(String raw) {
        if (raw == null) {
            return null;
        }
        Matcher m = VERSION.matcher(raw);
        if (!m.find()) {
            return null;
        }
        return new int[]{
            Integer.parseInt(m.group(1)),
            Integer.parseInt(m.group(2)),
            Integer.parseInt(m.group(3))
        };
    }

    private static boolean isNewer(int[] remote, int[] local) {
        for (int i = 0; i < 3; i++) {
            if (remote[i] != local[i]) {
                return remote[i] > local[i];
            }
        }
        return false;
    }
}
