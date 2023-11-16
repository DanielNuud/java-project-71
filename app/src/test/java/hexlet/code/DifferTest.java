package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testGenerateWhenFilesHaveDifferences() throws Exception {
        String currentDirectory = System.getProperty("user.dir");
        String filePath1 = currentDirectory + "/file1.json";
        String filePath2 = currentDirectory + "/file2.json";

        String result = Differ.generate(filePath1, filePath2);

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        assertEquals(expected, result);
    }
}