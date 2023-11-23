package hexlet.code;

import java.util.*;

public class Tree {
    public List<Map<String, Object>> buildTree(Map<String, String> map1, Map<String, String> map2) {
        Set<String> allKeys = new TreeSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());

        List<Map<String, Object>> diffList = new ArrayList<>();

        for (String key : allKeys) {
            if (!map2.containsKey(key)) {
                diffList.add(createDiffMap(key, "deleted", map1.get(key), null));
            } else if (!map1.containsKey(key)) {
                diffList.add(createDiffMap(key, "added", null, map2.get(key)));
            } else if (!map1.get(key).equals(map2.get(key))) {
                diffList.add(createDiffMap(key, "changed", map1.get(key), map2.get(key)));
            } else {
                diffList.add(createDiffMap(key, "unchanged", map1.get(key), null));
            }
        }

        return diffList;
    }

    private Map<String, Object> createDiffMap(String key, String type, String value1, String value2) {
        Map<String, Object> diffMap = new LinkedHashMap<>();
        diffMap.put("key", key);
        diffMap.put("type", type);
        if (value1 != null) {
            diffMap.put("value1", value1);
        }
        if (value2 != null) {
            diffMap.put("value2", value2);
        }
        return diffMap;
    }
}
