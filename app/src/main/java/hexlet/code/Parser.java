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

public class Parser {
    public static Map<String, Object> readFileBySpecialty(String filePath) throws Exception {
        if (filePath.endsWith(".json")) {
            return readJSONFile(filePath);
        } else if (filePath.endsWith(".yaml")) {
            return readYAMLFile(filePath);
        }
        return new HashMap<>();
    }
    public static Map<String, Object> readJSONFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        String fileContent = new String(Files.readAllBytes(Paths.get(absolutePath)));
        return objectMapper.readValue(fileContent, new TypeReference<Map<String, Object>>() {
        });
    }

    public static Map<String, Object> readYAMLFile(String filePath) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        String fileContent = new String(Files.readAllBytes(Paths.get(absolutePath)));
        return mapper.readValue(fileContent, new TypeReference<Map<String, Object>>() {
        });
    }
}
