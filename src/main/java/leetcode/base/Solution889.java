package leetcode.base;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class Solution889 {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return doConstructFromPrePost(preorder, postorder, 0, 0, preorder.length);
    }

    private TreeNode doConstructFromPrePost(int[] preorder, int[] postorder, int preStart, int postStart, int size) {
        if (size == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (size == 1) {
            return root;
        }
        int len = 0;
        for (int i = 0; i < size; ++i) {
            if (preorder[preStart + 1] == postorder[i + postStart]) {
                len = i + 1;
                break;
            }
        }
        root.left = doConstructFromPrePost(preorder, postorder,
                preStart + 1, postStart, len);
        root.right = doConstructFromPrePost(preorder, postorder,
                preStart + 1 + len, postStart + len, size - len - 1);
        return root;
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
