package leetcode;

/**
 * 在二叉树中增加一行
 * https://leetcode-cn.com/problems/add-one-row-to-tree/
 */
public class Solution623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        dfs(root, val, depth, 1);
        return root;
    }

    private void dfs(TreeNode node, int val, int depth, int currDepth) {
        if (node == null) {
            return;
        }
        if (depth == currDepth + 1) {
            TreeNode tmp = node.left;
            node.left = new TreeNode(val);
            node.left.left = tmp;
            tmp = node.right;
            node.right = new TreeNode(val);
            node.right.right = tmp;
            return;
        } else {
            dfs(node.left, val, depth, currDepth + 1);
            dfs(node.right, val, depth, currDepth + 1);
        }
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
