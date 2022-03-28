package leetcode;

/**
 * 面试题 02.01. 移除重复节点
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class Solution02_01 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode op = head;
        while (op != null) {
            ListNode sub = op;
            while (sub.next != null) {
                if (sub.next.val == op.val) {
                    sub.next = sub.next.next;
                } else {
                    sub = sub.next;
                }
            }
            op = op.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
