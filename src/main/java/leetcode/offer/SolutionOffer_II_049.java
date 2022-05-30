package leetcode.offer;

/**
 * 剑指 Offer II 049. 从根节点到叶节点的路径数字之和
 * https://leetcode.cn/problems/3Etpl5/
 */
public class SolutionOffer_II_049 {

    private int res;

    public int sumNumbers_1(TreeNode root) {
        res = 0;
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

    private void dfs_1(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        int tmp = 10 * num + root.val;
        if (root.left == null && root.right == null) {
            res += tmp;
            return;
        }
        dfs(root.left, tmp);
        dfs(root.right, tmp);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        preSum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return preSum;
        }
        return dfs(root.left, preSum) + dfs(root.right, preSum);
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
