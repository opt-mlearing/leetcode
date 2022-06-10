package leetcode.typical;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 04.03. 特定深度节点链表
 * https://leetcode.cn/problems/list-of-depth-lcci/
 */
public class Solution04_03 {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(tree);
        List<ListNode> list = new ArrayList<ListNode>();
        while (!stack.isEmpty()) {
            int size = stack.size();
            ListNode dummy = new ListNode(-1);
            ListNode listNode = dummy;
            for (int i = 0; i < size; ++i) {
                TreeNode treeNoe = stack.poll();
                listNode.next = new ListNode(treeNoe.val);
                listNode = listNode.next;
                if (treeNoe.left != null) {
                    stack.offer(treeNoe.left);
                }
                if (treeNoe.right != null) {
                    stack.offer(treeNoe.right);
                }
            }
            list.add(dummy.next);
        }
        int size = list.size();
        ListNode[] res = new ListNode[size];
        for (int i = 0; i < size; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
