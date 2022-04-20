package leetcode.base;

/**
 * 1457. 二叉树中的伪回文路径
 * https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */
public class Solution1457 {

    private int res = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        int n = num ^ (1 << root.val);
        if (root.left == null && root.right == null && (n == 0 || (n & (n - 1)) == 0)) {
            ++res;
        }
        dfs(root.left, n);
        dfs(root.right, n);
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
