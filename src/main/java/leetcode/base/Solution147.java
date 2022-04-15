package leetcode.base;

/**
 * 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 避免操作头节点出现空指针异常.
        ListNode dummy = new ListNode(0, head);
        // 当前节点机器之前的已经完成生序.
        ListNode sortedNode = dummy.next;
        // 开始排序.
        ListNode node = head.next;
        while (node != null) {
            if (sortedNode.val <= node.val) {
                sortedNode = sortedNode.next;
            } else {
                // 从伪节点开始.
                ListNode pre = dummy;
                while (pre.next.val <= node.val) {
                    pre = pre.next;
                }
                sortedNode.next = node.next;
                node.next = pre.next;
                pre.next = node;
            }
            node = sortedNode.next;
        }
        return dummy.next;
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
