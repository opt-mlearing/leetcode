package leetcode.base;

/**
 * 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        // 连成环
        k = len - k % len;
        tail.next = head;
        while (k-- > 0) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
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
