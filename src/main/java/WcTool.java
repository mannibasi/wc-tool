import java.io.*;
import java.util.Arrays;

public class WcTool {
    public String execute(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String filename = args[1];

        switch (args[0]) {
            case "-c", "-m" -> sb.append(getByteCount(filename)).append(" ");
            case "-l" -> sb.append(getLineCount(filename)).append(" ");
            case "-w" -> sb.append(getWordCount(filename)).append(" ");
            default -> {
                sb.append(getByteCount(filename)).append(" ")
                        .append(getLineCount(filename)).append(" ")
                        .append(getWordCount(filename)).append(" ");
            }
        }
        return sb.append(filename).toString();
    }

    private long getByteCount(String filename) throws IOException {
        try (InputStream inputStream = getClass().getResourceAsStream(filename)) {
            return inputStream.readAllBytes().length;
        }
    }

    private long getLineCount(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream(filename)))) {
            return reader.lines().count();
        }
    }

    private long getWordCount(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream(filename)))) {
            return reader.lines()
                    .flatMap(line -> Arrays.stream(line.trim().split("\\s")))
                    .filter(word -> !word.isEmpty())
                    .count();
        }
    }
}