package leetcode.offer;

/**
 * 剑指 Offer II 028. 展平多级双向链表
 * https://leetcode.cn/problems/Qv1Da2/
 */
public class SolutionOffer_II_028 {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        dfs(node);
        return head;
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }
        Node last = null;
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
                last = child;
                node.child = null;
            } else {
                last = node;
            }
            node = next;
        }
        return last;
    }

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
