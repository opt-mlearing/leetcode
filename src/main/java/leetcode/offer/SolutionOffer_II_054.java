package leetcode.offer;

/**
 * 剑指 Offer II 054. 所有大于等于节点的值之和
 * https://leetcode-cn.com/problems/w6cpku/
 */
public class SolutionOffer_II_054 {

    private int val;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        val += node.val;
        node.val = val;
        dfs(node.left);
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
