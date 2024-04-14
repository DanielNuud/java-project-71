package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<Object, Object> parseContent(String content, String dataFormat) throws IOException {
        return switch (dataFormat) {
            case "json" -> new ObjectMapper(new JsonFactory()).readValue(content, new TypeReference<>() { });
            case "yml", "yaml" -> new ObjectMapper(new YAMLFactory()).readValue(content, new TypeReference<>() { });
            default -> throw new IOException("Unsupported dataFormat");
        };
    }
}
