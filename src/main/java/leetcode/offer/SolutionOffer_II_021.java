package leetcode.offer;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * https://leetcode.cn/problems/SLwz0R/
 */
public class SolutionOffer_II_021 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int size = listNodeLength(node);
        ListNode dummy = new ListNode();
        dummy.next = head;
        node = dummy;
        for (int i = 1; i <= size - n; ++i) {
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
    }

    private int listNodeLength(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
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
