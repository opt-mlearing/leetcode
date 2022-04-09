package leetcode.offer;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class SolutionOffer_68 {

    private TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        for (; ; ) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        dfs(root, p, q);
        return ancestor;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        if ((root.val >= Math.min(p.val, q.val)) && (root.val <= Math.max(p.val, q.val))) {
            ancestor = root;
            return;
        }
        dfs(root.left, p, q);
        dfs(root.right, p, q);
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
