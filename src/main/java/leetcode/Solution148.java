package leetcode;

public class Solution148 {

    public static void main(String[] args) {
        Solution148 solution = new Solution148();
        ListNode node3 = new ListNode(3);
        ListNode node1 = new ListNode(1, node3);
        ListNode node2 = new ListNode(2, node1);
        ListNode head = new ListNode(4, node2);
        ListNode node = solution.sortList(head);
        System.out.println("node-- " + node);
    }

    public ListNode sortList(ListNode head) {
        return sortOperation(head, null);
    }

    private ListNode sortOperation(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        // 注意这里tail可能为空或者不为空.
        // 拆分后子链表最小单位为1.
        if (head.next == tail) {
            // 断开head && tail 之间的连接.
            // 断开与tail的连接，tail的信息会被丢失，所以二叉的断点节点不会在上二分和下二分重复.
            head.next = null;
            return head;
        }
        // 若以head 为头节点的链表长度大于2，则继续从中间拆开.
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            // 队列长度可为基数|| 偶数.
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode head1 = sortOperation(head, slow);
        ListNode head2 = sortOperation(slow, tail);
        ListNode merge = mergeOperation(head1, head2);
        return merge;
    }

    private ListNode mergeOperation(ListNode head1, ListNode head2) {
        ListNode fakeNode = new ListNode();
        ListNode tmp = fakeNode;
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                tmp.next = node1;
                node1 = node1.next;
            } else {
                tmp.next = node2;
                node2 = node2.next;
            }
            tmp = tmp.next;
        }
        if (node1 != null) {
            tmp.next = node1;
        } else if (node2 != null) {
            tmp.next = node2;
        }
        return fakeNode.next;
    }

    static public class ListNode {
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
