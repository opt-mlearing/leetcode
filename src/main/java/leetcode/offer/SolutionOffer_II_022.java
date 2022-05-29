package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 022. 链表中环的入口节点
 * https://leetcode.cn/problems/c32eOV/
 */
public class SolutionOffer_II_022 {

    public ListNode detectCycle_fast_slow(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode node1 = head;
                ListNode node2 = fast;
                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            }
        }
        return null;
    }

    public ListNode detectCycle_hash(ListNode head) {
        if (head == null) {
            return null;
        }
        Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        while (head != null) {
            int count = map.getOrDefault(head, 0) + 1;
            if (count == 2) {
                return head;
            }
            map.put(head, count);
            head = head.next;
        }
        return null;
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
