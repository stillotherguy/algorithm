package algorithm.cache;

import java.util.*;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class LRUCache {

    private Deque<Node> deque;

    private Map<Integer, Node> cache;

    private int capacity;

    static class Node {
        int key;

        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.deque = new LinkedList<>();
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        deque.remove(node);
        deque.addFirst(node);

        return node.value;
    }


    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node old = cache.get(key);

            Node newer = new Node(key, value);
            cache.put(key, newer);
            deque.remove(old);
            deque.addFirst(newer);

            return;
        }

        if (this.capacity == cache.size()) {
            Node last = deque.getLast();
            deque.removeLast();
            cache.remove(last.key);
        }

        Node cur = new Node(key, value);
        deque.addFirst(cur);
        cache.put(cur.key, cur);
    }

    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        deque.addFirst("4");
        deque.addFirst("5");
        deque.addFirst("6");
        deque.addFirst("7");
        deque.addFirst("8");

        deque.addLast("9");
        deque.addLast("10");
        deque.addLast("11");
        deque.addLast("12");
        deque.addLast("13");
        deque.addLast("14");
        deque.addLast("15");
        deque.addLast("16");
        deque.addLast("17");
    }
}
