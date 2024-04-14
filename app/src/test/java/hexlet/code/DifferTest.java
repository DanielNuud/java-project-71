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
        String expected = "[ {\n" +
                "  \"key\" : \"config\",\n" +
                "  \"type\" : \"added\",\n" +
                "  \"value1\" : \"\",\n" +
                "  \"value2\" : \"latest\"\n" +
                "}, {\n" +
                "  \"key\" : \"enable\",\n" +
                "  \"type\" : \"changed\",\n" +
                "  \"value1\" : true,\n" +
                "  \"value2\" : false\n" +
                "}, {\n" +
                "  \"key\" : \"good\",\n" +
                "  \"type\" : \"changed\",\n" +
                "  \"value1\" : null,\n" +
                "  \"value2\" : 13\n" +
                "}, {\n" +
                "  \"key\" : \"host\",\n" +
                "  \"type\" : \"unchanged\",\n" +
                "  \"value1\" : \"hexlet.io\",\n" +
                "  \"value2\" : \"hexlet.io\"\n" +
                "}, {\n" +
                "  \"key\" : \"ip\",\n" +
                "  \"type\" : \"changed\",\n" +
                "  \"value1\" : [ \"192.1.1.1\", \"192.0.0.1\", \"168.168.1.1\" ],\n" +
                "  \"value2\" : [ \"192.1.1.3\", \"192.0.0.1\", \"168.168.1.1\" ]\n" +
                "}, {\n" +
                "  \"key\" : \"object\",\n" +
                "  \"type\" : \"changed\",\n" +
                "  \"value1\" : {\n" +
                "    \"key1\" : \"one\",\n" +
                "    \"key2\" : \"two\"\n" +
                "  },\n" +
                "  \"value2\" : {\n" +
                "    \"key1\" : \"two\",\n" +
                "    \"key2\" : \"one\"\n" +
                "  }\n" +
                "}, {\n" +
                "  \"key\" : \"port\",\n" +
                "  \"type\" : \"changed\",\n" +
                "  \"value1\" : 1,\n" +
                "  \"value2\" : 10\n" +
                "}, {\n" +
                "  \"key\" : \"wait\",\n" +
                "  \"type\" : \"removed\",\n" +
                "  \"value1\" : 4,\n" +
                "  \"value2\" : \"\"\n" +
                "} ]";

        assertThat(Differ.generate(jsonPath1, jsonPath2, "json")).isEqualTo(expected);
        assertThat(Differ.generate(ymlPath1, ymlPath2, "json")).isEqualTo(expected);
    }

    @Test
    public void testStylish() throws IOException {

        String expected = "{\n"
                + "  + config: latest\n"
                + "  - enable: true\n"
                + "  + enable: false\n"
                + "  - good: null\n"
                + "  + good: 13\n"
                + "    host: hexlet.io\n"
                + "  - ip: [192.1.1.1, 192.0.0.1, 168.168.1.1]\n"
                + "  + ip: [192.1.1.3, 192.0.0.1, 168.168.1.1]\n"
                + "  - object: {key1=one, key2=two}\n"
                + "  + object: {key1=two, key2=one}\n"
                + "  - port: 1\n"
                + "  + port: 10\n"
                + "  - wait: 4\n"
                + "}";


        assertThat(Differ.generate(jsonPath1, jsonPath2)).isEqualTo(expected);
        assertThat(Differ.generate(ymlPath1, ymlPath2)).isEqualTo(expected);
    }
    @Test
    public void testPlain() throws IOException {
        String expected = "Property 'config' was added with value: 'latest'\n"
                + "Property 'enable' was updated. From true to false\n"
                + "Property 'good' was updated. From null to 13\n"
                + "Property 'ip' was updated. From [complex value] to [complex value]\n"
                + "Property 'object' was updated. From [complex value] to [complex value]\n"
                + "Property 'port' was updated. From 1 to 10\n"
                + "Property 'wait' was removed";



        assertThat(Differ.generate(jsonPath1, jsonPath2, "plain")).isEqualTo(expected);
        assertThat(Differ.generate(ymlPath1, ymlPath2, "plain")).isEqualTo(expected);
    }

    private String getTestFile() throws IOException {
        return Files.readString(Path.of(userDir + "expected_json.txt").toAbsolutePath().normalize());
    }

    private String getPathToFile(String filename) {
        return userDir + filename;
    }

}
