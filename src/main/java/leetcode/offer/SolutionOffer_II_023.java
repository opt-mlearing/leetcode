package leetcode.offer;

/**
 * 剑指 Offer II 023. 两个链表的第一个重合节点
 * https://leetcode.cn/problems/3u1WK4/
 */
public class SolutionOffer_II_023 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        // 若不相交，则必在null相遇.
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
