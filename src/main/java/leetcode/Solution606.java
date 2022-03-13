package leetcode;

/**
 * 根据二叉树创建字符串
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
public class Solution606 {

    public String tree2str(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        preOrder(root, buffer);
        return buffer.subSequence(1, buffer.length() - 1).toString();
    }

    private void preOrder(TreeNode root, StringBuffer buffer) {
        if (root == null) {
            return;
        }
        buffer.append("(");
        buffer.append(String.valueOf(root.val));
        if (root.left == null && root.right != null) {
            buffer.append("()");
            preOrder(root.right, buffer);
        } else {
            preOrder(root.left, buffer);
            preOrder(root.right, buffer);
        }
        buffer.append(")");
    }

    public static class TreeNode {
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
