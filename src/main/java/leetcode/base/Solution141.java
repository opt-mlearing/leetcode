package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle_method1(ListNode head) {
        ListNode fockNode = new ListNode(0);
        fockNode.next = head;
        ListNode currNode = fockNode;
        Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        while (currNode.next != null) {
            currNode = currNode.next;
            int inCount = map.getOrDefault(currNode, 0) + 1;
            if (inCount == 2) {
                return true;
            }
            map.put(currNode, inCount);
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
