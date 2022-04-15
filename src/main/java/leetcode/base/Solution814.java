package leetcode.base;

/**
 * 二叉树剪枝
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 */
public class Solution814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return hasOne(root) ? root : null;
    }

    private boolean hasOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = hasOne(root.left);
        boolean right = hasOne(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return root.val == 1 || left || right;
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
