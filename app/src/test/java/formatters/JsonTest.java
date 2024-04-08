package formatters;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonTest {
    private final String trueJsonResult = "[{\"field\":\"chars1\",\"status\":\"unchanged\",\"value\""
            + ":[\"a\",\"b\",\"c\"]},{\"field\":\"chars2\",\"status\":\"changed\",\"value1\""
            + ":[\"d\",\"e\",\"f\"],\"value2\":false},{\"field\":\"checked\",\"status\":\"changed\""
            + ",\"value1\":false,\"value2\":true},{\"field\":\"default\",\"status\":\"changed\",\"value1\""
            + ":null,\"value2\":[\"value1\",\"value2\"]},{\"field\":\"id\",\"status\":\"changed\",\"value1\""
            + ":45,\"value2\":null},{\"field\":\"key1\",\"status\":\"removed\",\"value1\":\"value1\"},{\"field\""
            + ":\"key2\",\"status\":\"added\",\"value2\":\"value2\"},{\"field\":\"numbers1\",\"status\":\"unchanged\","
            + "\"value\":[1,2,3,4]},{\"field\":\"numbers2\",\"status\":\"changed\",\"value1\":[2,3,4,5],\"value2\""
            + ":[22,33,44,55]},{\"field\":\"numbers3\",\"status\":\"removed\",\"value1\":[3,4,5]},{\"field\""
            + ":\"numbers4\",\"status\":\"added\",\"value2\":[4,5,6]},{\"field\":\"obj1\",\"status\""
            + ":\"added\",\"value2\":{\"isNested\":true,\"nestedKey\":\"value\"}},{\"field\":\"setting1\",\"status\""
            + ":\"changed\",\"value1\":\"Some value\",\"value2\":\"Another value\"},{\"field\":\"setting2\",\"status\""
            + ":\"changed\",\"value1\":200,\"value2\":300},{\"field\":\"setting3\",\"status\":\"changed\",\"value1\""
            + ":true,\"value2\":\"none\"}]";

    @Test
    void formatTestForJSONFile() throws Exception {
        final String currentDirectory = System.getProperty("user.dir");
        final String filePath1 = currentDirectory + "/src/test/resources/stylishFileTest1.json";
        final String filePath2 = currentDirectory + "/src/test/resources/stylishFileTest2.json";

        assertEquals(trueJsonResult, Differ.generate(filePath1, filePath2, "json"));
    }

    @Test
    void formatTestForYMLFile() throws Exception {
        final String currentDirectory = System.getProperty("user.dir");
        final String filePath1 = currentDirectory + "/src/test/resources/stylishFileTest1.yml";
        final String filePath2 = currentDirectory + "/src/test/resources/stylishFileTest2.yml";

        assertEquals(trueJsonResult, Differ.generate(filePath1, filePath2, "json"));
    }

}
