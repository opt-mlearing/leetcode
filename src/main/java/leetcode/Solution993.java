package leetcode;

/**
 * 二叉树的堂兄弟节点
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class Solution993 {

    // x
    private int xDepth = -1;
    private TreeNode xParent = null;
    private boolean xFound = false;
    // y
    private int yDepth = -1;
    private TreeNode yParent = null;
    private boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return (xFound && yFound && (xDepth == yDepth) && (xParent != yParent));
    }

    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null) {
            return;
        }
        if (x == root.val) {
            xDepth = depth;
            xParent = parent;
            xFound = true;
        }
        if (y == root.val) {
            yDepth = depth;
            yParent = parent;
            yFound = true;
        }
        if (xFound && yFound) {
            return;
        }
        dfs(root.left, root, depth + 1, x, y);
        if (xFound && yFound) {
            return;
        }
        dfs(root.right, root, depth + 1, x, y);
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
