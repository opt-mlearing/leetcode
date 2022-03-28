package leetcode;

/**
 * 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        ListNode pre = null;
        ListNode after = null;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == left) {
                pre = curr;
            }
            curr = curr.next;
            if (count == right) {
                after = curr;
            }
        }
        ListNode afterHead = after.next;
        after.next = null;
        ListNode preHead = pre.next;
        pre.next = reverse(preHead);
        preHead.next = afterHead;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
