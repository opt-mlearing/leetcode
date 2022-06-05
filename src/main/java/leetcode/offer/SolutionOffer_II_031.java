package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 031. 最近最少使用缓存
 * https://leetcode.cn/problems/OrIXps/
 */
public class SolutionOffer_II_031 {

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public SolutionOffer_II_031(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Node>();
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            Node insert = new Node(key, value);
            cache.put(key, insert);
            addHead(insert);
            while (cache.size() > capacity) {
                removeTail();
            }
        } else {
            Node node = cache.get(key);
            node.value = value;
            moveHead(node);
        }
    }

    private void removeTail() {
        Node node = tail.pre;
        removeNode(node);
        cache.remove(node.key);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void moveHead(Node node) {
        removeNode(node);
        addHead(node);
    }

    private static class Node {
        private Node pre;
        private Node next;
        private int value;
        private int key;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }

        public Node() {
            this.pre = null;
            this.next = null;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */