package leetcode;

/**
 * 面试题 02.05. 链表求和
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 */
public class Solution02_05 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int add = 0;
        while (l1 != null || l2 != null) {
            int tmp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            add = tmp / 10;
            curr.next = new ListNode(tmp % 10);
            curr = curr.next;
            if (l1 == null) {
                l1 = null;
            } else {
                l1 = l1.next;
            }
            if (l2 == null) {
                l2 = null;
            } else {
                l2 = l2.next;
            }
        }
        if (add > 0) {
            curr.next = new ListNode(add);
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
