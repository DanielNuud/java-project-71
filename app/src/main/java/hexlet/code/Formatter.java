package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.Stylish;

import java.util.TreeMap;
import java.util.TreeSet;

public class Formatter {
    public static String makeFormat(TreeMap<String, Object> value1, TreeMap<String, Object> value2,
                                    String format, TreeSet<String> setKeys) throws Exception {

        return switch (format) {
            case "json" -> Json.format(value1, value2, setKeys);
            case "stylish" -> Stylish.format(value1, value2, setKeys);
            case "plain" -> Plain.format(value1, value2, setKeys);
            default -> throw new Exception("Unknown output format!");
        };
    }
}
