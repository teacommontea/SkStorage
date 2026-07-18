import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public final class DocGrabber {

    private DocGrabber() {}

    private static final String MARKER = "SkStorage - PLEASE READ BEFORE CONTINUING";

    private record Entry(
            String title, String excerpt, boolean dev, String detail,
            String webEquivalent, String notes, boolean test, String caveats,
            String pkg, String cls, String member) {}

    public static void main(String[] args) throws IOException {
        Path root = Path.of("").toAbsolutePath();
        List<Path> srcRoots = List.of(
                root.resolve("SkStorage").resolve("src").resolve("main").resolve("java"));
        Path outDir = root.resolve("SkStorage").resolve("docs");
        Files.createDirectories(outDir);

        List<Path> files = new ArrayList<>();
        for (Path src : srcRoots) {
            if (!Files.isDirectory(src)) {
                continue;
            }
            try (Stream<Path> walk = Files.walk(src)) {
                walk.filter(p -> p.toString().endsWith(".java"))
                        .filter(p -> {
                            String s = p.toString().replace('\\', '/');
                            return !s.contains("/teacommontea/skstorage/docs/");
                        })
                        .forEach(files::add);
            }
        }

        List<Entry> pub = new ArrayList<>();
        List<Entry> dev = new ArrayList<>();
        int scanned = 0;
        int reviewedFiles = 0;

        for (Path path : files) {
            scanned++;
            String text = Files.readString(path, StandardCharsets.UTF_8);
            String code = stripBanner(text);
            if (!Pattern.compile("@Reviewed\\s*\\(\\s*true\\s*\\)").matcher(code).find()) {
                continue;
            }
            reviewedFiles++;

            String cls = className(code);
            String pkg = packageName(code);

            for (Entry e : parseEntries(code, pkg, cls)) {
                if (e.dev()) {
                    dev.add(e);
                } else {
                    pub.add(e);
                }
            }
        }

        Files.writeString(outDir.resolve("wiki.json"), renderPublic(pub), StandardCharsets.UTF_8);
        Files.writeString(outDir.resolve("dev.json"), renderDev(dev), StandardCharsets.UTF_8);

        System.out.printf("scanned %d files, %d reviewed. wiki.json: %d public entries, dev.json: %d dev entries%n",
                scanned, reviewedFiles, pub.size(), dev.size());
    }

    private static String stripBanner(String text) {
        if (!text.contains(MARKER)) {
            return text;
        }
        int close = text.indexOf("*/");
        return close >= 0 ? text.substring(close + 2) : text;
    }

    private static String packageName(String code) {
        Matcher m = Pattern.compile("(?m)^\\s*package\\s+([\\w.]+)\\s*;").matcher(code);
        if (m.find()) {
            String p = m.group(1);
            int dot = p.lastIndexOf('.');
            return dot >= 0 ? p.substring(dot + 1) : p;
        }
        return "";
    }

    private static String className(String code) {
        Matcher m = Pattern.compile(
                "(?m)^\\s*(?:public\\s+|final\\s+|abstract\\s+|sealed\\s+|non-sealed\\s+)*"
                        + "(?:class|interface|enum|record|@interface)\\s+(\\w+)").matcher(code);
        return m.find() ? m.group(1) : "";
    }

    private static List<Entry> parseEntries(String code, String pkg, String cls) {
        List<Entry> out = new ArrayList<>();
        int idx = 0;
        while (true) {
            int at = code.indexOf("@Description(", idx);
            if (at < 0) {
                break;
            }
            int open = at + "@Description".length();
            int close = matchParen(code, open);
            if (close < 0) {
                break;
            }
            String body = code.substring(open + 1, close);
            Map<String, String> fields = parseFields(body);
            String member = memberAfter(code, close + 1, cls);

            boolean dev = boolField(body, "dev");
            boolean test = boolField(body, "test");
            out.add(new Entry(
                    fields.getOrDefault("title", ""),
                    fields.getOrDefault("excerpt", ""),
                    dev,
                    fields.getOrDefault("detail", ""),
                    fields.getOrDefault("webEquivalent", ""),
                    fields.getOrDefault("notes", "null"),
                    test,
                    fields.getOrDefault("caveats", "null"),
                    pkg, cls, member));
            idx = close + 1;
        }
        return out;
    }

    private static int matchParen(String s, int openParenIdx) {
        int depth = 0;
        boolean inStr = false;
        for (int i = openParenIdx; i < s.length(); i++) {
            char c = s.charAt(i);
            if (inStr) {
                if (c == '\\') {
                    i++;
                } else if (c == '"') {
                    inStr = false;
                }
                continue;
            }
            if (c == '"') {
                inStr = true;
            } else if (c == '(') {
                depth++;
            } else if (c == ')') {
                depth--;
                if (depth == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static Map<String, String> parseFields(String body) {
        Map<String, String> out = new LinkedHashMap<>();
        Matcher m = Pattern.compile("(\\w+)\\s*=\\s*\"((?:\\\\.|[^\"\\\\])*)\"").matcher(body);
        while (m.find()) {
            out.put(m.group(1), unescape(m.group(2)));
        }
        return out;
    }

    private static boolean boolField(String body, String name) {
        Matcher m = Pattern.compile("\\b" + name + "\\s*=\\s*(true|false)\\b").matcher(body);
        return m.find() && "true".equals(m.group(1));
    }

    private static String unescape(String s) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' && i + 1 < s.length()) {
                char n = s.charAt(++i);
                switch (n) {
                    case 'n' -> b.append('\n');
                    case 't' -> b.append('\t');
                    case '"' -> b.append('"');
                    case '\\' -> b.append('\\');
                    default -> b.append(n);
                }
            } else {
                b.append(c);
            }
        }
        return b.toString();
    }

    private static String memberAfter(String code, int from, String cls) {
        String rest = code.substring(from);
        String[] lines = rest.split("\n");
        for (String raw : lines) {
            String line = raw.strip();
            if (line.isEmpty() || line.startsWith("@")) {
                continue;
            }
            Matcher method = Pattern.compile(
                    "(?:public|private|protected|static|final|abstract|synchronized|default|\\s)*"
                            + "[\\w<>\\[\\],.?& ]+\\s+(\\w+)\\s*\\(").matcher(line);
            if (method.find()) {
                return method.group(1);
            }
            Matcher type = Pattern.compile(
                    "(?:public|private|protected|final|abstract|sealed|non-sealed|static|\\s)*"
                            + "(?:class|interface|enum|record|@interface)\\s+(\\w+)").matcher(line);
            if (type.find()) {
                return type.group(1);
            }
            return cls;
        }
        return cls;
    }

    private static String jsonStr(String s) {
        StringBuilder b = new StringBuilder("\"");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '"' -> b.append("\\\"");
                case '\\' -> b.append("\\\\");
                case '\n' -> b.append("\\n");
                case '\r' -> b.append("\\r");
                case '\t' -> b.append("\\t");
                default -> {
                    if (c < 0x20) {
                        b.append(String.format("\\u%04x", (int) c));
                    } else {
                        b.append(c);
                    }
                }
            }
        }
        return b.append('"').toString();
    }

    private static void addStr(List<String> lines, String key, String value) {
        if (value == null || value.equals("null") || value.isEmpty()) {
            return;
        }
        lines.add("      " + jsonStr(key) + ": " + jsonStr(value));
    }

    private static String renderEntries(List<Entry> entries, boolean dev) {
        StringBuilder b = new StringBuilder();
        b.append("{\n");
        b.append("  \"count\": ").append(entries.size()).append(",\n");
        b.append("  \"entries\": [\n");
        for (int i = 0; i < entries.size(); i++) {
            Entry e = entries.get(i);
            List<String> lines = new ArrayList<>();
            addStr(lines, "title", e.title());
            addStr(lines, "excerpt", e.excerpt());
            addStr(lines, "detail", e.detail());
            addStr(lines, "webEquivalent", e.webEquivalent());
            addStr(lines, "notes", e.notes());
            if (e.test()) {
                lines.add("      " + jsonStr("test") + ": true");
            }
            addStr(lines, "caveats", e.caveats());
            if (dev) {
                addStr(lines, "package", e.pkg());
                addStr(lines, "class", e.cls());
                addStr(lines, "member", e.member());
            }
            b.append("    {\n");
            b.append(String.join(",\n", lines)).append("\n");
            b.append("    }").append(i < entries.size() - 1 ? "," : "").append("\n");
        }
        b.append("  ]\n");
        b.append("}\n");
        return b.toString();
    }

    private static String renderPublic(List<Entry> entries) {
        return renderEntries(entries, false);
    }

    private static String renderDev(List<Entry> entries) {
        return renderEntries(entries, true);
    }
}
