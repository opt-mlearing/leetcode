package leetcode.base;

/**
 * 2236. 判断根结点是否等于子结点之和
 * https://leetcode.cn/problems/root-equals-sum-of-children/
 */
public class Solution2236 {

    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.val == (root.left.val + root.right.val);
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
