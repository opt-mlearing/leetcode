package leetcode;

/**
 * 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Solution24 {

    // 通过递归的方式.
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 通过循环迭代的方式.
    public ListNode swapPairs_by_sequence_search(ListNode head) {
        ListNode fock = new ListNode(0, head);
        ListNode tmp = fock;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode first = tmp.next;
            ListNode second = tmp.next.next;
            tmp.next = second;
            first.next = second.next;
            second.next = first;
            tmp = first;
        }
        return fock.next;

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
