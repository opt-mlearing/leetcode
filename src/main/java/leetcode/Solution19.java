package leetcode;

/**
 * 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 获取链表的长度
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        ListNode forkNode = new ListNode(0, head);
        ListNode node = forkNode;
        for (int i = 1; i < len - n + 1; ++i) {
            node = node.next;
        }
        node.next = node.next.next;
        return forkNode.next;

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
