package leetcode.base;

/**
 * 2265. 统计值等于子树平均值的节点数
 * https://leetcode.cn/problems/count-nodes-equal-to-average-of-subtree/
 */
public class Solution2265 {

    private int res;

    public int averageOfSubtree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            // 点个数，value和
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int tmpVal = root.val + left[1] + right[1];
        int tmpCount = 1 + left[0] + right[0];
        if (tmpVal / tmpCount == root.val) {
            res++;
        }
        return new int[]{tmpCount, tmpVal};
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
