package leetcode.offer;

/**
 * 剑指 Offer II 050. 向下的路径节点之和
 * https://leetcode.cn/problems/6eUYwP/
 */
public class SolutionOffer_II_050 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode root, int targetSum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (targetSum == root.val) {
            res++;
        }
        res += dfs(root.left, targetSum - root.val);
        res += dfs(root.right, targetSum - root.val);
        return res;
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
