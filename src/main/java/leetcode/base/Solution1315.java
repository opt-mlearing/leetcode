package leetcode.base;

/**
 * 1315. 祖父节点值为偶数的节点和
 * https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class Solution1315 {

    private int res = 0;

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 0;
        if (root.left != null) {
            dfs(root, root.left, root.left.left);
            dfs(root, root.left, root.left.right);
        }
        if (root.right != null) {
            dfs(root, root.right, root.right.left);
            dfs(root, root.right, root.right.right);
        }
        return res;
    }

    private void dfs(TreeNode grand, TreeNode parent, TreeNode node) {
        if (node == null) {
            return;
        }
        assert grand != null;
        assert parent != null;
        if (grand.val % 2 == 0) {
            res += node.val;
        }
        dfs(parent, node, node.left);
        dfs(parent, node, node.right);
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