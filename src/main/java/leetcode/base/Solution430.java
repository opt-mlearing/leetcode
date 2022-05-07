package leetcode.base;

/**
 * 430. 扁平化多级双向链表
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class Solution430 {

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node node = head;
        dfs(node);
        return head;
    }

    private Node dfs(Node node) {
        if (node == null) {
            return node;
        }
        Node lastNode = null;
        while (node != null) {
            Node next = node.next;
            if (node.child != null) {
                Node child = dfs(node.child);
                node.next = node.child;
                node.child.prev = node;
                if (next != null) {
                    next.prev = child;
                    child.next = next;
                }
                lastNode = child;
                node.child = null;
            } else {
                lastNode = node;
            }
            node = next;
        }
        return lastNode;
    }

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
