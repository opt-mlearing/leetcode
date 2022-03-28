package leetcode;

/**
 * 二叉树的坡度
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 */
public class Solution563 {

    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
        return totalTilt;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        int left = dfs(root.left);
        int right = dfs(root.right);
        totalTilt += Math.abs(left - right);
        return sum + left + right;
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
