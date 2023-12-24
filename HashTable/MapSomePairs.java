package HashTable;

import java.util.HashMap;
import java.util.Map;

public class MapSomePairs {

    private Map<String, Integer> myMap = new HashMap<String, Integer>();

    public void insert(String key, int val) {
        myMap.put(key, val);
    }

    public int sum(String prefix) {
        int result = 0;
        for (Map.Entry entry : myMap.entrySet()) {
            String key = (String) entry.getKey();
            if (key.startsWith(prefix)) {
                result += (int) entry.getValue();
            }
        }
        return result;
    }
}
