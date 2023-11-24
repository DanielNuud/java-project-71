package formatters;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlainTest {
    private final String truePlainResult = """
            Property 'chars2' was updated. From [complex value] to false
            Property 'checked' was updated. From false to true
            Property 'default' was updated. From null to [complex value]
            Property 'id' was updated. From 45 to null
            Property 'key1' was removed
            Property 'key2' was added with value: 'value2'
            Property 'numbers2' was updated. From [complex value] to [complex value]
            Property 'numbers3' was removed
            Property 'numbers4' was added with value: [complex value]
            Property 'obj1' was added with value: [complex value]
            Property 'setting1' was updated. From 'Some value' to 'Another value'
            Property 'setting2' was updated. From 200 to 300
            Property 'setting3' was updated. From true to 'none'
            """;

    @Test
    void formatTestForJSONFile() throws Exception {
        final String currentDirectory = System.getProperty("user.dir");
        final String filePath1 = currentDirectory + "/src/test/resources/stylishFileTest1.json";
        final String filePath2 = currentDirectory + "/src/test/resources/stylishFileTest2.json";

        assertEquals(truePlainResult, Differ.generate(filePath1, filePath2, "plain"));
    }


    @Test
    void formatTestForYMLFile() throws Exception {
        final String currentDirectory = System.getProperty("user.dir");
        final String filePath1 = currentDirectory + "/src/test/resources/stylishFileTest1.yml";
        final String filePath2 = currentDirectory + "/src/test/resources/stylishFileTest2.yml";

        assertEquals(truePlainResult, Differ.generate(filePath1, filePath2, "plain"));
    }
}