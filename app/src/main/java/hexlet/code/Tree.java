package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Tree {
    public static List<Map<Object, Object>> build(Map<Object, Object> firstData, Map<Object, Object> secondData) {
        Set<Object> keys = new TreeSet<>();
        keys.addAll(firstData.keySet());
        keys.addAll(secondData.keySet());
        List<Map<Object, Object>> result = new ArrayList<>();
        keys.forEach(key -> {
            if (!secondData.containsKey(key)) {
                result.add(makeNewMap(key, "removed", firstData.get(key), ""));
            } else if (!firstData.containsKey(key)) {
                result.add(makeNewMap(key, "added", "", secondData.get(key)));
            } else {
                Object value1 = firstData.get(key);
                Object value2 = secondData.get(key);
                String type = compareValues(value1, value2) ? "unchanged" : "changed";
                result.add(makeNewMap(key, type, value1, value2));
            }
        });
        return result;
    }

    private static boolean compareValues(Object value1, Object value2) {
        if (value1 == null && value2 == null) {
            return true;
        }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    public static Map<Object, Object> makeNewMap(Object key, String type, Object value1, Object value2) {
        Map<Object, Object> newmap = new TreeMap<>();
        newmap.put("key", key);
        newmap.put("type", type);
        newmap.put("value1", value1);
        newmap.put("value2", value2);
        return newmap;
    }
}
