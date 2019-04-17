import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> cache;
    LinkedHashSet<Integer> keys;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        keys = new LinkedHashSet<>();
    }

    public int get(int key) {
        Integer value = cache.get(key);
        if (value == null) {
            return -1;
        }
        keys.remove(key);
        keys.add(key);
        return value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            keys.remove(key);
            keys.add(key);
            cache.put(key, value);
        } else {
            if (cache.size() == capacity) {
                Integer firstKey = keys.iterator().next();
                keys.remove(firstKey);
                cache.remove(firstKey);
            }
            keys.add(key);
            cache.put(key, value);
        }
    }
}
