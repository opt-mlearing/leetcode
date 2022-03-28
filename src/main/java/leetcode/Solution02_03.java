package leetcode;

/**
 * 面试题 02.03. 删除中间节点
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */
public class Solution02_03 {

    public void deleteNode(ListNode node) {
        ListNode pre = null;
        ListNode curr = node;
        while (curr.next != null) {
            curr.val = curr.next.val;
            pre = curr;
            curr = curr.next;
        }
        pre.next = null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
