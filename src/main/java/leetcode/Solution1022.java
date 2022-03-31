package leetcode;

/**
 * 从根到叶的二进制数之和
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class Solution1022 {

    private int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;

    }

    private void dfs(TreeNode root, int pre) {
        if (root == null) {
            return;
        }
        pre = pre * 2 + root.val;
        if (root.left == null && root.right == null) {
            res += pre;
        }
        dfs(root.left, pre);
        dfs(root.right, pre);
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
