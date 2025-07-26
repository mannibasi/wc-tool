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
}
