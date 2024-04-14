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
            } else if (String.valueOf(firstData.get(key)).equals(String.valueOf(secondData.get(key)))) {
                result.add(makeNewMap(key, "unchanged", firstData.get(key), secondData.get(key)));
            } else {
                result.add(makeNewMap(key, "changed", firstData.get(key), secondData.get(key)));
            }
        });
        return result;
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
