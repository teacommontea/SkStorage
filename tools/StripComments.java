import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class StripComments {

    private StripComments() {}

    private record Comment(int line, String kind, String body) {}

    private record ScanResult(String stripped, List<Comment> comments) {}

    public static void main(String[] args) throws IOException {
        Path root = Path.of("").toAbsolutePath();
        Path src = root.resolve("SkStorage").resolve("src").resolve("main").resolve("java");
        Path out = root.resolve("SkStorage").resolve("comments");
        boolean dry = true;
        for (String a : args) {
            if (a.equals("--apply")) {
                dry = false;
            }
        }

        int changed = 0;
        int totalComments = 0;
        int totalScanned = 0;

        if (!Files.isDirectory(src)) {
            System.out.println("No source directory at " + src);
            return;
        }

        List<Path> files = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(src)) {
            walk.filter(p -> p.toString().endsWith(".java")).forEach(files::add);
        }

        for (Path path : files) {
            totalScanned++;
            String text = Files.readString(path, StandardCharsets.UTF_8);
            ScanResult r = scan(text);
            if (r.comments().isEmpty()) {
                continue;
            }
            changed++;
            totalComments += r.comments().size();

            if (!dry) {
                String rel = src.relativize(path).toString().replace('\\', '/');
                String relNoExt = rel.substring(0, rel.length() - ".java".length());
                Path sidecar = out.resolve(relNoExt + ".md");
                Files.createDirectories(sidecar.getParent());
                StringBuilder sb = new StringBuilder();
                sb.append("# Comments from ").append(rel).append("\n\n");
                for (Comment c : r.comments()) {
                    sb.append("### L").append(c.line()).append(" (").append(c.kind()).append(")\n\n")
                            .append(c.body()).append("\n\n");
                }
                Files.writeString(sidecar, sb.toString(), StandardCharsets.UTF_8);
                Files.writeString(path, cleanBlankRuns(r.stripped()), StandardCharsets.UTF_8);
            }
        }

        String label = dry ? "DRY-RUN" : "APPLIED";
        System.out.printf("%s: %d/%d files have comments, %d comments total%n",
                label, changed, totalScanned, totalComments);
    }

    private static ScanResult scan(String text) {
        StringBuilder out = new StringBuilder();
        List<Comment> comments = new ArrayList<>();
        int i = 0;
        int n = text.length();

        while (i < n) {
            char c = text.charAt(i);
            char nxt = i + 1 < n ? text.charAt(i + 1) : '\0';

            if (c == '"' && i + 3 <= n && text.startsWith("\"\"\"", i)) {
                out.append("\"\"\"");
                i += 3;
                while (i < n && !text.startsWith("\"\"\"", i)) {
                    out.append(text.charAt(i));
                    i++;
                }
                if (i < n) {
                    out.append("\"\"\"");
                    i += 3;
                }
                continue;
            }

            if (c == '"' || c == '\'') {
                char quote = c;
                out.append(c);
                i++;
                while (i < n) {
                    char ch = text.charAt(i);
                    out.append(ch);
                    if (ch == '\\') {
                        if (i + 1 < n) {
                            out.append(text.charAt(i + 1));
                            i += 2;
                            continue;
                        }
                    } else if (ch == quote) {
                        i++;
                        break;
                    }
                    i++;
                }
                continue;
            }

            if (c == '/' && nxt == '/') {
                int startLine = countNewlines(text, i) + 1;
                int j = i + 2;
                while (j < n && text.charAt(j) != '\n') {
                    j++;
                }
                comments.add(new Comment(startLine, "line", text.substring(i + 2, j).strip()));
                i = j;
                continue;
            }

            if (c == '/' && nxt == '*') {
                int startLine = countNewlines(text, i) + 1;
                int j = i + 2;
                while (j < n && !(text.charAt(j) == '*' && j + 1 < n && text.charAt(j + 1) == '/')) {
                    j++;
                }
                int end = Math.min(j + 2, n);
                String block = text.substring(i, end);
                if (isSkStorageHeader(block)) {
                    out.append(block);
                    i = end;
                    continue;
                }
                comments.add(new Comment(startLine, "block", text.substring(i + 2, Math.min(j, n)).strip()));
                i = j + 2;
                continue;
            }

            out.append(c);
            i++;
        }

        return new ScanResult(out.toString(), comments);
    }

    private static final String SKSTORAGE_HEADER_MARKER =
            "SkStorage - PLEASE READ BEFORE CONTINUING";

    private static boolean isSkStorageHeader(String block) {
        int start = 2;
        while (start < block.length() && (block.charAt(start) == ' ' || block.charAt(start) == '\t')) {
            start++;
        }
        return block.startsWith(SKSTORAGE_HEADER_MARKER, start);
    }

    private static int countNewlines(String text, int end) {
        int count = 0;
        for (int k = 0; k < end; k++) {
            if (text.charAt(k) == '\n') {
                count++;
            }
        }
        return count;
    }

    private static String cleanBlankRuns(String text) {
        String[] lines = text.split("\n", -1);
        StringBuilder result = new StringBuilder();
        boolean blank = false;
        boolean first = true;
        for (String ln : lines) {
            String stripped = stripTrailing(ln);
            if (stripped.isBlank()) {
                if (blank) {
                    continue;
                }
                blank = true;
            } else {
                blank = false;
            }
            if (!first) {
                result.append("\n");
            }
            result.append(stripped);
            first = false;
        }
        return result.toString();
    }

    private static String stripTrailing(String s) {
        int end = s.length();
        while (end > 0 && Character.isWhitespace(s.charAt(end - 1))) {
            end--;
        }
        return s.substring(0, end);
    }
}
