package formatters;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StylishTest {
    private final String trueStylishResult = """
            {
                chars1: [a, b, c]
              - chars2: [d, e, f]
              + chars2: false
              - checked: false
              + checked: true
              - default: null
              + default: [value1, value2]
              - id: 45
              + id: null
              - key1: value1
              + key2: value2
                numbers1: [1, 2, 3, 4]
              - numbers2: [2, 3, 4, 5]
              + numbers2: [22, 33, 44, 55]
              - numbers3: [3, 4, 5]
              + numbers4: [4, 5, 6]
              + obj1: {nestedKey=value, isNested=true}
              - setting1: Some value
              + setting1: Another value
              - setting2: 200
              + setting2: 300
              - setting3: true
              + setting3: none
            }""";

    @Test
    void formatTestForJSONFile() throws Exception {
        final String currentDirectory = System.getProperty("user.dir");
        final String filePath1 = currentDirectory + "/src/test/resources/stylishFileTest1.json";
        final String filePath2 = currentDirectory + "/src/test/resources/stylishFileTest2.json";

        assertEquals(trueStylishResult, Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    void formatTestForYMLFile() throws Exception {
        final String currentDirectory = System.getProperty("user.dir");
        final String filePath1 = currentDirectory + "/src/test/resources/stylishFileTest1.yml";
        final String filePath2 = currentDirectory + "/src/test/resources/stylishFileTest2.yml";

        assertEquals(trueStylishResult, Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    void formatTestForSimilarFiles() throws Exception {

        String expected = "{"
                + "\n    chars1: [a, b, c]"
                + "\n    chars2: [d, e, f]"
                + "\n    checked: false"
                + "\n    default: null"
                + "\n    id: 45"
                + "\n    key1: value1"
                + "\n    numbers1: [1, 2, 3, 4]"
                + "\n    numbers2: [2, 3, 4, 5]"
                + "\n    numbers3: [3, 4, 5]"
                + "\n    setting1: Some value"
                + "\n    setting2: 200"
                + "\n    setting3: true"
                + "\n}";

        final String currentDirectory = System.getProperty("user.dir");
        final String filePath1 = currentDirectory + "/src/test/resources/stylishFileTest1.yml";
        final String filePath2 = currentDirectory + "/src/test/resources/stylishFileTest1.yml";

        final String actual = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(actual, expected);
    }

}
