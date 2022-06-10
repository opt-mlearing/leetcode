package leetcode.base;

/**
 * 1372. 二叉树中的最长交错路径
 * https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class Solution1372 {

    private int res;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return res;
    }

    private void dfs(TreeNode root, boolean isLeft, int length) {
        if (root == null) {
            return;
        }
        res = Math.max(res, length);
        if (isLeft) {
            if (root.left != null) {
                dfs(root.left, true, 1);
            }
            if (root.right != null) {
                dfs(root.right, false, length + 1);
            }
        } else {
            if (root.left != null) {
                dfs(root.left, true, length + 1);
            }
            if (root.right != null) {
                dfs(root.right, false, 1);
            }
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
