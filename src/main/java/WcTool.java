import java.io.*;
import java.net.URISyntaxException;
import java.util.Arrays;

public class WcTool {
    public String execute(String[] args) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(args[1]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        if(args[0].equals("-c")) {
            return inputStream.readAllBytes().length + " " + args[1];
        } else if (args[0].equals("-l")) {
            return reader.lines().count() + " " + args[1];
        } else if (args[0].equals("-w")) {
            long wordCount = reader.lines()
                    .flatMap(line -> Arrays.stream(line.trim().split("\\s")))
                    .filter(word -> !word.isEmpty())
                    .count();
            return wordCount + " " + args[1];
        }
        throw new IllegalArgumentException("Unknown option: " + args[0]);
    }
}
