package leetcode.offer;

/**
 * 剑指 Offer II 024. 反转链表
 * https://leetcode-cn.com/problems/UHnkqh/
 */
public class SolutionOffer2_024 {

    public ListNode reverseList(ListNode head) {
        // 迭代
        // ListNode node= reverseListIteration(head);
        // 递归.
        ListNode node = reverseListRecursion(head);
        return node;
    }

    private ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    private ListNode reverseListIteration(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
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
