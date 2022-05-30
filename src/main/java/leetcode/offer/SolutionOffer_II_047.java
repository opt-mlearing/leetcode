package leetcode.offer;

/**
 * 剑指 Offer II 047. 二叉树剪枝
 * https://leetcode.cn/problems/pOCWxh/
 */
public class SolutionOffer_II_047 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return hasOne(root) ? root : null;
    }

    private boolean hasOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = hasOne(root.left);
        boolean right = hasOne(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return root.val == 1 || left || right;
    }

    public TreeNode pruneTree_1(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0) {
            root.left = null;
        }
        if (right == 0) {
            root.right = null;
        }
        return left + right + root.val;
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
