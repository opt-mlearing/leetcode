package leetcode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class Solution02_02 {

    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }

    public int kthToLast_1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        int size = 0;
        while (node.next != null) {
            node = node.next;
            ++size;
        }
        int count = size - k;
        while (head != null && count > 0) {
            head = head.next;
            count--;
        }
        return head.val;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
