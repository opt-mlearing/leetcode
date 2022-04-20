package leetcode.base;

/**
 * 1145. 二叉树着色游戏
 * https://leetcode-cn.com/problems/binary-tree-coloring-game/
 */
public class Solution1145 {

    private int xLeft = 0;
    private int xRight = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        int half = n / 2;
        // 选右节点 || 选左节点 || 选父节点
        if (xRight > half || xLeft > half || xLeft + xRight < half) {
            return true;
        }
        return false;
    }

    private int dfs(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, x);
        int right = dfs(root.right, x);
        if (root.val == x) {
            xLeft = left;
            xRight = right;
        }
        return 1 + left + right;
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
