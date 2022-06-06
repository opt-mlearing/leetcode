package leetcode.offer;

/**
 * 剑指 Offer 07. 重建二叉树
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 */
public class SolutionOffer_07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if ((preLeft > preRight) && (inLeft > inRight)) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int pos = inLeft;
        while (preorder[preLeft] != inorder[pos]) {
            pos++;
        }
        int leftLength = pos - inLeft;
        root.left = dfs(preorder, inorder, preLeft + 1, preLeft + leftLength, inLeft, pos - 1);
        root.right = dfs(preorder, inorder, preLeft + leftLength + 1, preRight, pos + 1, inRight);
        return root;
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
