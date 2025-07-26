import java.io.*;
import java.net.URISyntaxException;

public class WcTool {
    public String execute(String[] args) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(args[1]);
        if(args[0].equals("-c")) {
            return inputStream.readAllBytes().length + " " + args[1];
        } else if (args[0].equals("-l")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            return reader.lines().count() + " " + args[1];
        }
        throw new IllegalArgumentException("Unknown option: " + args[0]);
    }
}
