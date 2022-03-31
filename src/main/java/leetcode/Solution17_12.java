package leetcode;

/**
 * 面试题 17.12. BiNode
 * https://leetcode-cn.com/problems/binode-lcci/
 */
public class Solution17_12 {

    private TreeNode pre;

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        pre = dummy;
        dfs(root);
        return dummy.right;
    }

    // 改变root的left && right的指向.
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        pre.right = root;
        root.left = null;
        pre = pre.right;
        dfs(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
