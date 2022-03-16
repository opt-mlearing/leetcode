package leetcode;

/**
 * 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 */
public class Solution86 {

    // 使用双队列的实现.
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fockL = new ListNode(0);
        ListNode low = fockL;
        ListNode fockH = new ListNode(0);
        ListNode high = fockH;
        while (head != null) {
            if (head.val >= x) {
                high.next = head;
                high = high.next;
            } else {
                low.next = head;
                low = low.next;
            }
            head = head.next;
        }
        high.next = null;
        low.next = fockH.next;
        return fockL.next;
    }

    public static class ListNode {
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
