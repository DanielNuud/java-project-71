package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testGenerateWhenFilesHaveDifferences() throws Exception {
        String currentDirectory = System.getProperty("user.dir");
        String filePath1 = currentDirectory + "/src/test/resources/file1.json";
        String filePath2 = currentDirectory + "/src/test/resources/file2.json";

        String result = Differ.generate(filePath1, filePath2);

        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertEquals(expected, result);
    }

    @Test
    void testGenerateWhenFilesAreSimilar() throws Exception {
        String currentDirectory = System.getProperty("user.dir");
        String filePath1 = currentDirectory + "/src/test/resources/file1.yaml";
        String filePath2 = currentDirectory + "/src/test/resources/file2.yaml";

        String result = Differ.generate(filePath1, filePath2);

        String expected = "{"
                + "\n    follow: false"
                + "\n    host: hexlet.io"
                + "\n    proxy: 123.234.53.22"
                + "\n    timeout: 50"
                + "\n}";

        assertEquals(expected, result);
    }

}
