package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.StyleFormatter;
import formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatText(List<Map<String, Object>> list, String format) throws IOException {
        StyleFormatter formatterDriver = switch (format) {
            case "stylish" -> new Stylish();
            case "plain" -> new Plain();
            case "json" -> new Json();
            default -> throw new IOException("Unknown format for result set");
        };
        return formatterDriver.formatText(list);
    }
}
