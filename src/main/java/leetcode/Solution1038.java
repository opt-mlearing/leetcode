package leetcode;

/**
 * 从二叉搜索树到更大和树
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class Solution1038 {

    private int val = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        // 反过来，先右再左
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
