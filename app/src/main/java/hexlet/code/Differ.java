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

        Set<String> processedKeys = new HashSet<>();

        for (String key : keys) {
            if (!processedKeys.contains(key)) {
                boolean containsKey1 = data1.containsKey(key);
                boolean containsKey2 = data2.containsKey(key);

                if (containsKey1 && !containsKey2) {
                    result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                    processedKeys.add(key);
                } else if (!containsKey1 && containsKey2) {
                    result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
                    processedKeys.add(key);
                } else if (containsKey1 && containsKey2) {
                    if (!data1.get(key).equals(data2.get(key))) {
                        result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                        result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
                        processedKeys.add(key);
                    } else {
                        result.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
                        processedKeys.add(key);
                    }
                }
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
