import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WcTool {
    public String execute(String[] args) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(args[1]);
        return inputStream.readAllBytes().length + " " + args[1];
    }
}
