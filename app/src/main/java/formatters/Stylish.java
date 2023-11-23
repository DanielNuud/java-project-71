package formatters;

import java.util.TreeMap;
import java.util.TreeSet;

public class Stylish {
    static StringBuilder result;
    static String valOne;
    static String valTwo;

    public static String format(TreeMap<String, Object> value1, TreeMap<String, Object> value2,
                                TreeSet<String> setKeys) {

        result = new StringBuilder("{\n");

        for (final String key: setKeys) {
            valOne = String.valueOf(value1.get(key));
            valTwo = String.valueOf(value2.get(key));

            ifFilesHasKeys(value2.containsKey(key) && value1.containsKey(key), key);

            if (!value1.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(valTwo).append("\n");
            } else if (!value2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(valOne).append("\n");
            }
        }

        System.out.println(result.toString() + "}");
        return result.append("}").toString();
    }

    private static void ifFilesHasKeys(boolean condition, String key) {

        if (condition) {
            if (valOne.equals(valTwo)) {
                result.append("    ").append(key).append(": ").append(valOne).append("\n");
            } else {
                result.append("  - ").append(key).append(": ").append(valOne).append("\n");
                result.append("  + ").append(key).append(": ").append(valTwo).append("\n");
            }
        }

    }
}
