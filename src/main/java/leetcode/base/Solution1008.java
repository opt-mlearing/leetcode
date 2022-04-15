package leetcode.base;

/**
 * 前序遍历构造二叉搜索树
 * https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class Solution1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return dfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        if (left == right) {
            return root;
        }
        int mid = -1;
        int tmp = preorder[left];
        for (int i = left + 1; i <= right; ++i) {
            if (tmp > preorder[i]) {
                mid = i;
            }
        }
        if (mid != -1) {
            root.left = dfs(preorder, left + 1, mid);
            root.right = dfs(preorder, mid + 1, right);
        } else {
            root.right = dfs(preorder, left + 1, right);
        }
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
