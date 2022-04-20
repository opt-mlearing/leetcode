package leetcode.base;

/**
 * 1325. 删除给定值的叶子节点
 * https://leetcode-cn.com/problems/delete-leaves-with-a-given-value/
 */
public class Solution1325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        return dfs(root, target);
    }

    private TreeNode dfs(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left, target);
        root.right = dfs(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
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
