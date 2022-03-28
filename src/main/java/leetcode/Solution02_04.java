package leetcode;

/**
 * 面试题 02.04. 分割链表
 * https://leetcode-cn.com/problems/partition-list-lcci/
 */
public class Solution02_04 {

    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-x);
        ListNode small = smallDummy;
        ListNode bigDummy = new ListNode(-x);
        ListNode big = bigDummy;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                small.next = node;
                small = small.next;
            } else {
                big.next = node;
                big = big.next;
            }
            node = node.next;
        }
        big.next = null;
        small.next = bigDummy.next;
        return smallDummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
