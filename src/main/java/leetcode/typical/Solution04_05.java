package leetcode.typical;

/**
 * 面试题 04.05. 合法二叉搜索树
 * https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 */
public class Solution04_05 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return dfs(root.left, min, root) && dfs(root.right, root, max);
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
