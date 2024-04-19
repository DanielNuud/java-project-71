package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    private final String userDir = System.getProperty("user.dir") + "/src/test/resources/fixtures/";
    private final String jsonPath1 = getPathToFile("file1.json");
    private final String jsonPath2 = getPathToFile("file2.json");
    private final String ymlPath1 = getPathToFile("file1.yaml");
    private final String ymlPath2 = getPathToFile("file2.yaml");

    @Test
    public void testJson() throws IOException {
        String expected = getTestFile("expected_json.txt").trim();

        assertThat(Differ.generate(jsonPath1, jsonPath2, "json")).isEqualTo(expected);
        assertThat(Differ.generate(ymlPath1, ymlPath2, "json")).isEqualTo(expected);
    }

    @Test
    public void testStylish() throws IOException {

        String expected = getTestFile("expected_stylish.txt").trim();

        assertThat(Differ.generate(jsonPath1, jsonPath2, "stylish")).isEqualTo(expected);
        assertThat(Differ.generate(ymlPath1, ymlPath2, "stylish")).isEqualTo(expected);
    }
    @Test
    public void testPlain() throws IOException {
        String expected = getTestFile("expected_plain.txt").trim();

        assertThat(Differ.generate(jsonPath1, jsonPath2, "plain")).isEqualTo(expected);
        assertThat(Differ.generate(ymlPath1, ymlPath2, "plain")).isEqualTo(expected);
    }

    @Test
    public void testWithoutFormat() throws IOException {
        String expected = getTestFile("expected_stylish.txt").trim();

        assertThat(Differ.generate(jsonPath1, jsonPath2)).isEqualTo(expected);
        assertThat(Differ.generate(ymlPath1, ymlPath2)).isEqualTo(expected);
    }

    private String getTestFile(String filename) throws IOException {
        return Files.readString(Path.of(userDir + filename).toAbsolutePath().normalize());
    }

    private String getPathToFile(String filename) {
        return userDir + filename;
    }

}
