package leetcode.base;

public class Solution143 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next= listNode2;
        listNode2.next= listNode3;
        listNode3.next= listNode4;
        listNode4.next= listNode5;
        Solution143 solution143 = new Solution143();
        solution143.reorderList(listNode1);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        head = doMerge(head, head2);
    }

    private ListNode doMerge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        // head1要么比head2 长1，要么一样长.
        while (head1 != null && head2 != null) {
            ListNode next1= head1.next;
            ListNode next2= head2.next;
            head1.next= null;
            head2.next= null;
            current.next= head1;
            current.next.next= head2;
            current= current.next.next;
            head1= next1;
            head2= next2;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (fast.next != null && fast.next.next != null) {
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
