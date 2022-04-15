package leetcode.base;

/**
 * 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class Solution938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val <= high && root.val >= low) {
            res += root.val;
        }
        res += rangeSumBST(root.left, low, high);
        res += rangeSumBST(root.right, low, high);
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
