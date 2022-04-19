package leetcode.base;

/**
 * 1123. 最深叶节点的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
public class Solution1123 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return root;
        }
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        if (left == right) {
            return root;
        }
        if (left > right) {
            return lcaDeepestLeaves(root.left);
        }
        return lcaDeepestLeaves(root.right);
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
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
