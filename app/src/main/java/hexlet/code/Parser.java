package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> readFileBySpeciality(String absoluteFilePath, String filePath) throws Exception {
        if (filePath.endsWith(".json")) {
            return readJSONFile(absoluteFilePath);
        } else if (filePath.endsWith(".yaml")) {
            return readYAMLFile(absoluteFilePath);
        } else {
            throw new Exception("Use formats: .json / .yml / .yaml");
        }
    }
    public static TreeMap<String, Object> readJSONFile(String filePath) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final TreeMap<String, Object> value;
        value = objectMapper.readValue(filePath, new TypeReference<>() {});
        return value;
    }

    public static TreeMap<String, Object> readYAMLFile(String filePath) throws Exception {
        final ObjectMapper objectMapper = new YAMLMapper();
        final TreeMap<String, Object> value;
        value = objectMapper.readValue(filePath, new TypeReference<>() {});
        return value;
    }
}
