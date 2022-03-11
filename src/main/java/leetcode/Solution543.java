package leetcode;

/**
 * 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class Solution543 {

    // 最小直径为0, 其对应高度为1
    // 存在最大直径的两个节点A && B，A、B到最近公共节点高度差 H_a+ H_b -1
    private int maxDiameter = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter - 1;
    }

    // 返回以root为树的最大高度.
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        maxDiameter = Math.max(maxDiameter, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public class TreeNode {
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
