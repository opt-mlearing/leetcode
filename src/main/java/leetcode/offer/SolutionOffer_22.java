package leetcode.offer;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class SolutionOffer_22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        int size = getLength(node);
        node = head;
        for (int i = 1; i <= size - k; ++i) {
            node = node.next;
        }
        return node;
    }

    private int getLength(ListNode head) {
        int depth = 0;
        while (head != null) {
            head = head.next;
            depth++;
        }
        return depth;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
