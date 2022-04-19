package leetcode.base;

/**
 * 1026. 节点与其祖先之间的最大差值
 * https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class Solution1026 {

    private int maxDiff = 0;

    // 推荐此方法，先到底，自底向上一次循环解决，避免重复计算.
    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;
        recursion(root);
        return maxDiff;
    }

    private int[] recursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            maxDiff = Math.max(maxDiff, 0);
            return new int[]{root.val, root.val};
        }
        int[] left = recursion(root.left);
        int[] right = recursion(root.right);
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        if (left != null) {
            low = Math.min(low, left[0]);
            high = Math.max(high, left[1]);
        }
        if (right != null) {
            low = Math.min(low, right[0]);
            high = Math.max(high, right[1]);
        }
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - low), Math.abs(root.val - high)));
        // 注意，这里一定需要max && min 一下.
        return new int[]{Math.min(low, root.val), Math.max(high, root.val)};
    }

    // 此方式，时间开销大.
    public int maxAncestorDiff_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root);
        // 注意，左右子节点非空的情况下，都需要循环递归.
        if (root.left != null) {
            maxAncestorDiff(root.left);
        }
        if (root.right != null) {
            maxAncestorDiff(root.right);
        }
        return maxDiff;
    }

    private void dfs(TreeNode ancestor, TreeNode node) {
        if (node == null) {
            return;
        }
        maxDiff = Math.max(maxDiff, Math.abs(ancestor.val - node.val));
        dfs(ancestor, node.left);
        dfs(ancestor, node.right);
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
