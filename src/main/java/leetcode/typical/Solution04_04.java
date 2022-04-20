package leetcode.typical;

/**
 * 面试题 04.04. 检查平衡性
 * https://leetcode-cn.com/problems/check-balance-lcci/
 */
public class Solution04_04 {

    private boolean res;

    public boolean isBalanced(TreeNode root) {
        res = true;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return 1 + Math.max(left, right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}