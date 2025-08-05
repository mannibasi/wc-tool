import java.io.*;
import java.util.Arrays;
import java.nio.file.Files;

public class WcTool {
    private static final String OPTION_BYTES = "-c";
    private static final String OPTION_CHARS = "-m";
    private static final String OPTION_LINES = "-l";
    private static final String OPTION_WORDS = "-w";

    public String execute(String[] args) throws IOException {
        return processFile(args[0], args[1]);
    }

    private String processFile(String option, String filename) throws IOException {
        File file = new File(filename);
        String content = readFile(file);
        return formatResult(option, content) + " " + filename;
    }

    private String readFile(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

    private String formatResult(String option, String content) {
        long byteCount = content.getBytes().length;
        long lineCount = countLines(content);
        long wordCount = countWords(content);
        return formatOutput(option, byteCount, lineCount, wordCount);
    }

    private String formatOutput(String option, long byteCount, long lineCount, long wordCount) {
        StringBuilder sb = new StringBuilder();
        switch (option) {
            case OPTION_BYTES, OPTION_CHARS -> sb.append(byteCount);
            case OPTION_LINES -> sb.append(lineCount);
            case OPTION_WORDS -> sb.append(wordCount);
            default -> sb.append(byteCount).append(" ")
                         .append(lineCount).append(" ")
                         .append(wordCount);
        }
        return sb.toString().trim();
    }

    private String readAll(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        return content.toString();
    }

    private long countLines(String input) {
        return input.split("\n").length;
    }

    private long countWords(String input) {
        return Arrays.stream(input.split("\\s"))
                .filter(word -> !word.isEmpty())
                .count();
    }
}
