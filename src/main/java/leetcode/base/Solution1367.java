package leetcode.base;

/**
 * 1367. 二叉树中的列表
 * https://leetcode.cn/problems/linked-list-in-binary-tree/
 */
public class Solution1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        // 注意，先判断ListNode
        if (head == null) {
            return true;
        }
        // 再判断TreeNode
        if (root == null) {
            return false;
        }
        if (head.val == root.val) {
            return dfs(head.next, root.left) || dfs(head.next, root.right);
        } else {
            return false;
        }
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

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
