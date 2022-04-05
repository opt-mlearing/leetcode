package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 * https://leetcode-cn.com/problems/lru-cache/submissions/
 */
public class LRUCache146 {

    private Map<Integer, LinkedNode> cache;
    private int capacity;
    private LinkedNode head;
    private LinkedNode tail;

    public LRUCache146(int capacity) {
        this.cache = new HashMap<Integer, LinkedNode>();
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点, 避免空指针的问题.
        this.head = new LinkedNode();
        this.tail = new LinkedNode();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            LinkedNode newNode = new LinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 先加添加至双向链表的头部
            addToHead(newNode);
            // 再判断是否需要减.
            while (this.cache.size() > this.capacity) {
                assert cache.size() == capacity + 1;
                // 如果超出容量，删除双向链表的尾部节点
                removeTail();
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeTail() {
        LinkedNode node = tail.prev;
        removeNode(node);
        // 删除哈希表中对应的项
        cache.remove(node.key);
    }

    private static class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
