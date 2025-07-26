import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WcToolTests {
    @Test
    void testByteCount() throws IOException {
        WcTool wcTool = new WcTool();
        String filePath = "test.txt";
        String[] args = {"-c", filePath};

        String result = wcTool.execute(args);

        assertEquals("342190 test.txt", result);
    }

    @Test
    void testLineCount() throws IOException {
        WcTool wcTool = new WcTool();
        String filePath = "test.txt";
        String[] args = {"-l", filePath};

        String result = wcTool.execute(args);

        assertEquals("7145 test.txt", result);
    }

}
