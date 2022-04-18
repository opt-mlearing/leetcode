package leetcode.base;

/**
 * 1080. 根到叶路径上的不足节点
 * https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 */
public class Solution1080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit) ? root : null;
    }

    private boolean dfs(TreeNode root, int sum, int limit) {
        if (root.left == null && root.right == null) {
            return root.val + sum >= limit;
        }
        // 这里必须都是false, 左右子树任意为true，root就不删除.
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = dfs(root.left, sum + root.val, limit);
        }
        if (root.right != null) {
            right = dfs(root.right, sum + root.val, limit);
        }
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return left || right;
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
