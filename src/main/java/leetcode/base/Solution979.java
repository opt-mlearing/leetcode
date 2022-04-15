package leetcode.base;

/**
 * 在二叉树中分配硬币
 * https://leetcode-cn.com/problems/distribute-coins-in-binary-tree/
 */
public class Solution979 {

    private int count;

    public int distributeCoins(TreeNode root) {
        doDistributeCoins(root);
        return count;
    }

    private int doDistributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树贡献金币数量，可能为正、为负、0
        int left = doDistributeCoins(root.left);
        // 右子树贡献金币数量，可能为正、为负、0
        int right = doDistributeCoins(root.right);
        // 每个节点，移动次数为abs(左子树贡献金币)加上abs(右子树贡献金币)
        count += Math.abs(left) + Math.abs(right);
        // 每个节点贡献的金币数为：左子树贡献的+右子树贡献的再加上自身这个节点可以贡献的
        return root.val + left + right - 1;
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
