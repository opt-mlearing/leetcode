package leetcode.offer;

/**
 * 剑指 Offer 18. 删除链表的节点
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author: caogl
 * @date: 2022/7/18, 1:06
 **/
public class SolutionOffer_18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
