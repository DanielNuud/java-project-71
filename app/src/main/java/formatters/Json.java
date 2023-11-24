package formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Json {
    private static Map<String, Object> result = new LinkedHashMap<>();
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static String valOne;
    private static String valTwo;

    public static String format(TreeMap<String, Object> value1, TreeMap<String, Object> value2,
                                TreeSet<String> setKeys) throws JsonProcessingException {

        for (final String key : setKeys) {
            valOne = String.valueOf(value1.get(key));
            valTwo = String.valueOf(value2.get(key));

            ifFilesHasKeys(value2.containsKey(key) && value1.containsKey(key), key);

            if (!value1.containsKey(key)) {
                result.put("+ " + key, valTwo);
            } else if (!value2.containsKey(key)) {
                result.put("- " + key, valOne);
            }
        }

        System.out.println(MAPPER.writeValueAsString(result));
        return MAPPER.writeValueAsString(result);
    }

    private static void ifFilesHasKeys(boolean condition, String key) {

        if (condition) {
            if (valOne.equals(valTwo)) {
                result.put(key, valOne);
            } else {
                result.put("- " + key, valOne);
                result.put("+ " + key, valTwo);
            }
        }
    }
}
