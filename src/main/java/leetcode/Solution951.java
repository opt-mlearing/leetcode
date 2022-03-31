package leetcode;

/**
 * 翻转等价二叉树
 * https://leetcode-cn.com/problems/flip-equivalent-binary-trees/
 */
public class Solution951 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if ((root1 == null && root2 != null) || (root2 == null && root1 != null)) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean front = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean reverse = flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
        return front || reverse;
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
