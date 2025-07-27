import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WcToolTests {
    private static final String TEST_FILE = WcToolTests.class.getResource("/test.txt").getFile();

    @Test
    void testByteCount() throws IOException {
        WcTool wcTool = new WcTool();
        String[] args = {"-c", TEST_FILE};

        String result = wcTool.execute(args);

        assertEquals("342190 " + TEST_FILE, result);
    }

    @Test
    void testLineCount() throws IOException {
        WcTool wcTool = new WcTool();
        String[] args = {"-l", TEST_FILE};

        String result = wcTool.execute(args);

        assertEquals("7145 " + TEST_FILE, result);
    }

    @Test
    void testWordCount() throws IOException {
        WcTool wcTool = new WcTool();
        String[] args = {"-w", TEST_FILE};

        String result = wcTool.execute(args);

        assertEquals("58164 " + TEST_FILE, result);
    }

    @Test
    void testCharCount() throws IOException {
        WcTool wcTool = new WcTool();
        String[] args = {"-m", TEST_FILE};

        String result = wcTool.execute(args);

        assertEquals("342190 " + TEST_FILE, result);
    }

    @Test
    void testDefaultByteLineAndWordCount() throws IOException {
        WcTool wcTool = new WcTool();
        String[] args = {"", TEST_FILE};

        String result = wcTool.execute(args);

        assertEquals("342190 7145 58164 " + TEST_FILE, result);
    }
}