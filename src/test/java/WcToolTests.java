import org.junit.jupiter.api.Test;

import java.io.IOException;

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

    @Test
    void testWordCount() throws IOException {
        WcTool wcTool = new WcTool();
        String filePath = "test.txt";
        String[] args = {"-w", filePath};

        String result = wcTool.execute(args);

        assertEquals("58164 test.txt", result);
    }

    @Test
    void testCharCount() throws IOException {
        WcTool wcTool = new WcTool();
        String filePath = "test.txt";
        String[] args = {"-m", filePath};

        String result = wcTool.execute(args);

        assertEquals("342190 test.txt", result);
    }

    @Test
    void testDefaultByteLineAndWordCount() throws IOException {
        WcTool wcTool = new WcTool();
        String filePath = "test.txt";
        String[] args = {"", filePath};

        String result = wcTool.execute(args);

        assertEquals("342190 7145 58164 test.txt", result);
    }

}
