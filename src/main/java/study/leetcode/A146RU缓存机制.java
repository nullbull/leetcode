package study.leetcode;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author niuzhenhao
 * @date 2021/2/27 10:04
 * @desc
 */
public class A146RU缓存机制 {
    static class LRUCache {

        private Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            map = new Map<>(capacity);
        }

        public int get(int key) {

            return  null == map.get(key) ? -1 : map.get(key);

        }

        public void put(int key, int value) {
            map.put(key, value);
        }

        public static class Map<K,V>  extends LinkedHashMap<K,V> {
            private int capacity;
            public Map(int capacity) {
                super(16, 0.75f, true);
                this.capacity = capacity;
            }

            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<K,V> eldest) {
                return size() > capacity;
            }
        }
    }

}
