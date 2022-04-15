package leetcode.base;

/**
 * 合并K个升序链表.
 *
 * @link https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class Solution23 {

    // 二分合并.
    public ListNode mergeKLists_divide_conquer(ListNode[] lists) {
        return divideConquerMerge(lists, 0, lists.length);
    }

    private ListNode divideConquerMerge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        } else if (left > right) {
            return null;
        } else {
            int mid = left + (right - left) / 2;
            ListNode leftNode = divideConquerMerge(lists, left, mid);
            ListNode rightNode = divideConquerMerge(lists, mid, right);
            return mergeListNode(leftNode, rightNode);
        }
    }

    // 顺序合并.
    public ListNode mergeKLists_byOrder(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode mergeNode = null;
        for (int i = 0; i < lists.length; ++i) {
            mergeNode = mergeListNode(mergeNode, lists[i]);
        }
        return mergeNode;
    }

    private ListNode mergeListNode(ListNode head1, ListNode head2) {
        ListNode fackNode = new ListNode(0);
        ListNode tmp = fackNode;
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val <= tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        if (tmp1 != null) {
            tmp.next = tmp1;
        } else if (tmp2 != null) {
            tmp.next = tmp2;
        }
        return fackNode.next;
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
