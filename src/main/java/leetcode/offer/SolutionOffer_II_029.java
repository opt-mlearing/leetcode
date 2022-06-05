package leetcode.offer;

/**
 * 剑指 Offer II 029. 排序的循环链表
 * https://leetcode.cn/problems/4ueAj6/
 */
public class SolutionOffer_II_029 {
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if (head == null) {
            head = insert;
            head.next = insert;
            return head;
        }
        Node node = head;
        while (node.next != head) {
            if (node.val > node.next.val) {
                // 在两个端点处.
                if (node.val < insertVal || insertVal < node.next.val) {
                    break;
                }
            }
            if (node.val <= insertVal && insertVal <= node.next.val) {
                break;
            }
            node = node.next;
        }
        insert.next = node.next;
        node.next = insert;
        return head;
    }

    private static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

}
