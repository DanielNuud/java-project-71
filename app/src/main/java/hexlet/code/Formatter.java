package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatText(List<Map<Object, Object>> list, String format) throws IOException {
        return switch (format) {
            case "stylish" -> Stylish.formatText(list);
            case "plain" -> Plain.formatText(list);
            case "json" -> Json.formatText(list);
            default -> throw new IOException("Unknown format for result set");
        };
    }
}
