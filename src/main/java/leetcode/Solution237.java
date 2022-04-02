package leetcode;

/**
 * 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class Solution237 {

    public void deleteNode(ListNode node) {
        ListNode pre = null;
        while (node.next != null) {
            ListNode next = node.next;
            node.val = next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
