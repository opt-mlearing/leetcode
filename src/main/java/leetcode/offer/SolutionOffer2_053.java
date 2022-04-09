package leetcode.offer;

/**
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 * https://leetcode-cn.com/problems/P5rCT8/
 */
public class SolutionOffer2_053 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
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
