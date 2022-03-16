package leetcode;

/**
 * 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tailA = headA;
        ListNode tailB = headB;
        while (tailA != tailB) {
            tailA = tailA == null ? headB : tailA.next;
            tailB = tailB == null ? headA : tailB.next;
        }
        return tailA;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
