package leetcode.base;

/**
 * 1339. 分裂二叉树的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/
 */
public class Solution1339 {

    private static final int MOD = 1000000007;
    private long res = Long.MIN_VALUE;
    private long sumNode = 0;

    public int maxProduct(TreeNode root) {
        sumNode = dfsSum(root);
        doMaxProduct(root);
        return (int) (res % MOD);
    }

    // 递归拆分再求乘积.
    public long doMaxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long sumLeft = doMaxProduct(root.left);
        long sumRight = doMaxProduct(root.right);
        long split = root.val + sumLeft + sumRight;
        res = Math.max(res, split * (sumNode - split));
        return split;
    }

    // 计算一颗树全部节点和.
    private long dfsSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + dfsSum(root.left) + dfsSum(root.right);
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
