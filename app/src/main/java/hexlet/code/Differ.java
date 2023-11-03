package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> data1 = readJSONFile(filePath1);
        Map<String, Object> data2 = readJSONFile(filePath2);

        List<String> keys = new ArrayList<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());
        Collections.sort(keys);

        StringBuilder result = new StringBuilder("{\n");

        for (String key : keys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 == null) {
                result.append("  + ").append(key).append(": ").append(value2).append("\n");
            } else if (value2 == null) {
                result.append("  - ").append(key).append(": ").append(value1).append("\n");
            } else if (!value1.equals(value2)) {
                result.append("  - ").append(key).append(": ").append(value1).append("\n");
                result.append("  + ").append(key).append(": ").append(value2).append("\n");
            }
        }

        result.append("}");
        return result.toString();
    }

    public static Map<String, Object> readJSONFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        return objectMapper.readValue(file, Map.class);
    }
}
