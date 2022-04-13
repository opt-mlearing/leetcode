package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class SolutionOffer_06 {

    // 这里只是用递归试试，最好的方式应该是用栈，压栈就可以.
    public int[] reversePrint(ListNode head) {
        ListNode node = reverse(head);
        List<Integer> list = new ArrayList<Integer>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int tmp : list) {
            res[i++] = tmp;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
