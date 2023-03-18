import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * solution146
 */
public class solution146 {

    public static void main(String[] args) {

    }
}

class LRUCache {

    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    // 最大容量
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        // 假如缓存中没有数据返回-1
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 缓存中有数据则使其为最近数据
        makeRecently(key);
        return cache.get(key);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);

    }

}