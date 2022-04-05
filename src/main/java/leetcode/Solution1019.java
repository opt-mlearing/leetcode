package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 链表中的下一个更大节点
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 */
public class Solution1019 {

    public int[] nextLargerNodes(ListNode head) {
        Deque<ListNode> stack = new LinkedList<ListNode>();
        Map<ListNode, Integer> mapping = new HashMap<ListNode, Integer>();
        ListNode node = head;
        int index = 0;
        while (node != null) {
            mapping.put(node, index++);
            node = node.next;
        }
        node = head;
        int[] res = new int[mapping.size()];
        while (node != null) {
            while (!stack.isEmpty() && stack.peek().val < node.val) {
                ListNode tmp = stack.pop();
                int k = mapping.get(tmp);
                res[k] = node.val;
            }
            stack.push(node);
            node = node.next;
        }
        return res;
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
