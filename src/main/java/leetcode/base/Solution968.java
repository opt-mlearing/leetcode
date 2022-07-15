package leetcode.base;

/**
 * 968. 监控二叉树
 * https://leetcode.cn/problems/binary-tree-cameras/
 *
 * @author caogaoli
 * @date 2022/7/15 16:03
 */
public class Solution968 {

    private int res;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dfs(root) == 0) {
            res++;
        }
        return res;
    }

    // 三种状态,0:未被监控覆盖到;1:已经被覆盖到;2:当前节点就是监控点.
    private int dfs(TreeNode root) {
        if (root == null) {
            // 空节点表示被覆盖到.
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 当前节点的子节点已经被覆盖.
        if (left == 1 && right == 1) {
            return 0;
        }
        // 当前节点是监控节点.
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        // 当前节点的左右子节点中有一个是2，监控节点.
        return 1;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

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
