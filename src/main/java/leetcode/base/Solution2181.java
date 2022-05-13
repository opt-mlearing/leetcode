package leetcode.base;

/**
 * 2181. 合并零之间的节点
 * https://leetcode.cn/problems/merge-nodes-in-between-zeros/
 */
public class Solution2181 {

    public ListNode mergeNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        int sum = 0;
        ListNode pre = null;
        while (right != null) {
            sum += right.val;
            if (right.val == 0) {
                left.val = sum;
                sum = 0;
                left.next = right;
                pre = left;
                left = left.next;
            }
            right = right.next;
        }
        pre.next = null;
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