package leetcode.base;

/**
 * 1373. 二叉搜索子树的最大键值和
 * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
 */
public class Solution1373 {

    private int res = 0;

    public int maxSumBST(TreeNode root) {
        doSumBST(root);
        return res;
    }

    private void doSumBST(TreeNode root) {
        if (isBST(root, null, null)) {
            sumBST(root);
            return;
        }
        doSumBST(root.left);
        doSumBST(root.right);
    }

    // 二叉子树的和
    private int sumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val + sumBST(root.left) + sumBST(root.right);
        res = Math.max(res, tmp);
        return tmp;
    }

    // 判断是否为二叉查找树.
    private boolean isBST(TreeNode root, TreeNode leftMin, TreeNode rightMax) {
        if (root == null) {
            return true;
        }
        if (leftMin != null && root.val <= leftMin.val) {
            return false;
        }
        if (rightMax != null && root.val >= rightMax.val) {
            return false;
        }
        return isBST(root.left, leftMin, root) && isBST(root.right, root, rightMax);
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
