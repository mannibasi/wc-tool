import java.io.*;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;

public class WcTool {
    public String execute(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String filename = args[1];
        File file = new File(filename);

        switch (args[0]) {
            case "-c", "-m" -> sb.append(getByteCount(file)).append(" ");
            case "-l" -> sb.append(getLineCount(file)).append(" ");
            case "-w" -> sb.append(getWordCount(file)).append(" ");
            default -> {
                sb.append(getByteCount(file)).append(" ")
                        .append(getLineCount(file)).append(" ")
                        .append(getWordCount(file)).append(" ");
            }
        }
        return sb.append(filename).toString();
    }

    private long getByteCount(File file) throws IOException {
        return Files.size(file.toPath());
    }

    private long getLineCount(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {
            return reader.lines().count();
        }
    }

    private long getWordCount(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {
            return reader.lines()
                    .flatMap(line -> Arrays.stream(line.trim().split("\\s")))
                    .filter(word -> !word.isEmpty())
                    .count();
        }
    }
}