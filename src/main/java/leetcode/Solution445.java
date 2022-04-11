package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 445. 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class Solution445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = findNumbers(l1);
        Deque<Integer> deque2 = findNumbers(l2);
        int carry = 0;
        Deque<Integer> deque = new LinkedList<Integer>();
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            int first = deque1.isEmpty() ? 0 : deque1.pollLast();
            int second = deque2.isEmpty() ? 0 : deque2.pollLast();
            int tmp = first + second + carry;
            carry = tmp / 10;
            deque.push(tmp % 10);
        }
        // 注意，这里可能存在进位.
        if (carry > 0) {
            deque.push(1);
        }
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (!deque.isEmpty()) {
            node.next = new ListNode(deque.pop());
            node = node.next;
        }
        return dummy.next;
    }

    private Deque<Integer> findNumbers(ListNode node) {
        Deque<Integer> stack = new LinkedList<Integer>();
        while (node != null) {
            stack.offer(node.val);
            node = node.next;
        }
        return stack;
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
