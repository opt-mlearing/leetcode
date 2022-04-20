package leetcode.base;

/**
 * 1261. 在受污染的二叉树中查找元素
 * https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree/
 */
public class FindElements1261 {

    private TreeNode root = null;

    public FindElements1261(TreeNode root) {
        dfsReset(root, 0);
        this.root = root;
    }

    private void dfsReset(TreeNode root, int value) {
        if (root == null) {
            return;
        }
        root.val = value;
        dfsReset(root.left, value * 2 + 1);
        dfsReset(root.right, value * 2 + 2);
    }

    public boolean find(int target) {
        return dfsSearch(this.root, target);
    }

    private boolean dfsSearch(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        return dfsSearch(root.left, target) || dfsSearch(root.right, target);
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
