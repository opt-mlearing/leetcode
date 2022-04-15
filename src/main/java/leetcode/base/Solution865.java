package leetcode.base;

/**
 * 具有所有最深节点的最小子树
 * https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class Solution865 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return root;
        }
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        if (left == right) {
            return root;
        }
        if (left > right) {
            return subtreeWithAllDeepest(root.left);
        }
        return subtreeWithAllDeepest(root.right);
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
