package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/27 10:25
 * @desc
 */
public class LRU缓存 {


   static class LRUCache {
        int capacity;

        int size = 0;
        LRUNode head;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            LRUNode head = new LRUNode(-1, -1);
            this.head = head;
        }

        public int get(int key) {
            LRUNode temp = head.next;
            LRUNode father = head;
            while (temp != null) {
                if (temp.key == key) {
                    father.next = temp.next;
                    temp.next = head.next;
                    head.next = temp;
                    return temp.value;
                }
                father = temp;
                temp = temp.next;
            }
            return head.value;
        }

        public void put(int key, int value) {

            if (get(key) != -1) {
                head.next.value = value;
            } else {
                LRUNode temp = head;
                LRUNode node = new LRUNode(key, value);
                node.next = head.next;
                head.next = node;
                size++;
                if (size > capacity) {
                    int count = size;
                    size--;
                    while (count > 1) {
                        temp = temp.next;
                        count--;
                    }
                    temp.next = null;
                }
            }

        }


    }
    public static class LRUNode {
        public LRUNode next;
        public int key;
        public int value;

        LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        LRUNode head = lruCache.head;
        while (head.next != null) {
            head = head.next;
            System.out.println(head.value);
        }

        lruCache.get(3);
        head = lruCache.head;
        while (head.next != null) {
            head = head.next;
            System.out.println(head.value);
        }
    }





}
