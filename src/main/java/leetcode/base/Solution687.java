package leetcode.base;

/**
 * 最长同值路径
 * https://leetcode-cn.com/problems/longest-univalue-path/
 */
public class Solution687 {

    private int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        doLongestUnivaluePath(root);
        return res;
    }

    // 从root开始，与root.val相等的最长左子树& 右子树.
    private int doLongestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = doLongestUnivaluePath(root.left);
        int right = doLongestUnivaluePath(root.right);
        int currLeft = 0;
        int currRight = 0;
        if (root.left != null && root.val == root.left.val) {
            currLeft += left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            currRight += right + 1;
        }
        res = Math.max(res, currLeft + currRight);
        return Math.max(currLeft, currRight);
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
