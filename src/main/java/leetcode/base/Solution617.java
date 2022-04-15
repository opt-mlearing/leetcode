package leetcode.base;

import java.util.ArrayList;

/**
 * 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class Solution617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int val = 0;
        val += (root1 == null ? 0 : root1.val);
        val += (root2 == null ? 0 : root2.val);
        TreeNode node = new TreeNode(val);
        node.left = dfs(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        node.right = dfs(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return node;
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
