package leetcode.offer;

/**
 * 剑指 Offer II 026. 重排链表
 * https://leetcode.cn/problems/LGjMqU/
 */
public class SolutionOffer_II_026 {

    public void reorderList(ListNode head) {
        ListNode midNode = mid(head);
        ListNode head2 = reorder(midNode.next, false);
        midNode.next = null;
        merge(head, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                head.next = head1;
                head = head.next;
                head1 = head1.next;
            }
            if (head2 != null) {
                head.next = head2;
                head = head.next;
                head2 = head2.next;
            }
        }
        return dummy.next;
    }

    private ListNode mid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reorder(ListNode head, boolean isRecursion) {
        return isRecursion ? reorder_recursion(head) : reorder_traverse(head);
    }

    private ListNode reorder_recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reorder_recursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    private ListNode reorder_traverse(ListNode head) {
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
