package leetcode.offer;

/**
 * 剑指 Offer 26. 树的子结构
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 *
 * @author caogaoli
 * @date 2022/7/15 16:44
 */
public class SolutionOffer_26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 题目中已经明确约定空树不是任意一个树的子结构.
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.right, B) || isSubStructure(A.left, B);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return dfs(a.left, b.left) && dfs(a.right, b.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
