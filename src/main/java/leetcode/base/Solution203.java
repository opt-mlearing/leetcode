package leetcode.base;

/**
 * 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Solution203 {

    // 递归.
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    // 循环.
    public ListNode removeElements_1(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode node = dummy;
        ListNode preNode = null;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
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
