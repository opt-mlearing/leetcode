package leetcode.typical;

/**
 * 面试题 04.12. 求和路径
 * https://leetcode-cn.com/problems/paths-with-sum-lcci/
 */
public class Solution04_12 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = dfs(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (sum == root.val) {
            res++;
        }
        int left = dfs(root.left, sum - root.val);
        int right = dfs(root.right, sum - root.val);
        return res + left + right;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
