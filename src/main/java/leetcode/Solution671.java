package leetcode;

/**
 * 二叉树中第二小的节点
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class Solution671 {

    private int result = -1;
    private int rootValue = 0;

    public int findSecondMinimumValue(TreeNode root) {
        rootValue = root.val;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (result != -1 && root.val > result) {
            return;
        }
        if (root.val > rootValue) {
            result = root.val;
        }
        dfs(root.left);
        dfs(root.right);
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
