package leetcode;

/**
 * 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Solution876 {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNode_method2(ListNode head) {
        if (head != null) {
            return doMiddleNode(head);
        }
        return head;
    }

    private ListNode doMiddleNode(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (two.next != null) {
            one = one.next;
            two = two.next;
            if (two.next != null) {
                two = two.next;
            }
        }
        return one;
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
