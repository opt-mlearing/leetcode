package leetcode.base;

/**
 * 707. 设计链表
 * https://leetcode.cn/problems/design-linked-list/
 */
public class MyLinkedList707 {

    private int size;
    private Node head;

    public MyLinkedList707() {
        size = 0;
        head = new Node(0);
    }

    public int get(int index) {
        if (index < -1 || index >= size) {
            return -1;
        }
        Node node = head;
        for (int i = 0; i < index + 1; ++i) {
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        Node pre = head;
        for (int i = 0; i < index; ++i) {
            pre = pre.next;
        }
        Node next = new Node(val, pre.next);
        pre.next = next;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node node = head;
        for (int i = 0; i < index; ++i) {
            node = node.next;
        }
        node.next = node.next.next;
        size--;
    }

    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
