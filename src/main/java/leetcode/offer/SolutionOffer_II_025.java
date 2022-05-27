package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 025. 链表中的两数相加
 * https://leetcode.cn/problems/lMSNwu/
 */
public class SolutionOffer_II_025 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = findNumbers(l1);
        Deque<Integer> deque2 = findNumbers(l2);
        int carry = 0;
        Deque<Integer> deque = new LinkedList<Integer>();
        while (!deque1.isEmpty() || !deque2.isEmpty() || carry > 0) {
            int first = deque1.isEmpty() ? 0 : deque1.pollLast();
            int second = deque2.isEmpty() ? 0 : deque2.pollLast();
            int tmp = first + second + carry;
            carry = tmp / 10;
            deque.push(tmp % 10);
        }
        // 注意，这里可能存在进位.
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

    // 直接反转都会超出内存限制，没办法.
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        ListNode head1 = reverse_traverse(l1);
        ListNode head2 = reverse_traverse(l2);
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            int tmp = val1 + val2 + carry;
            ListNode node = new ListNode(tmp % 10);
            carry = tmp / 10;
            head.next = node;
            head = head.next;
        }
        head = dummy.next;
        return reverse_traverse(head);
    }

    private ListNode reverse_traverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // reverse operation.
    private ListNode reverse_recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse_recursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
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
