package leetcode.offer;

/**
 * 剑指 Offer II 027. 回文链表
 * https://leetcode-cn.com/problems/aMhZSa/
 */
public class SolutionOffer_027 {

    public boolean isPalindrome(ListNode head) {
        ListNode firstHalfStart = head;
        ListNode firsetHalfEnd = findMiddle(firstHalfStart);
        ListNode secondHalfInversionStart = inversion(firsetHalfEnd.next);
        while (firstHalfStart != null && secondHalfInversionStart != null) {
            if (firstHalfStart.val != secondHalfInversionStart.val) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfInversionStart = secondHalfInversionStart.next;
        }
        return true;
    }

    // 倒置
    private ListNode inversion(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    // end first-half end ListNode
    private ListNode findMiddle(final ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
