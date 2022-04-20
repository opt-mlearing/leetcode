package leetcode.base;

/**
 * 1448. 统计二叉树中好节点的数目
 * https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree/
 */
public class Solution1448 {

    private int res = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 0;
        dfs(root, root.val);
        return res;
    }

    private void dfs(TreeNode root, int preMax) {
        if (root == null) {
            return;
        }
        if (root.val >= preMax) {
            res++;
        }
        int max = Math.max(root.val, preMax);
        dfs(root.left, max);
        dfs(root.right, max);
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
