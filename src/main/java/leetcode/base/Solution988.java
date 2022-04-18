package leetcode.base;

/**
 * 988. 从叶结点开始的最小字符串
 * https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/submissions/
 */
public class Solution988 {

    private String res = "~";

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder builder) {
        if (root == null) {
            return;
        }
        builder.append((char) ('a' + root.val));
        // 递归到叶子节点.
        if (root.left == null && root.right == null) {
            String path = builder.reverse().toString();
            // 注意，String.compareTo(..)就是按照字典序比较的.
            if (path.compareTo(res) < 0) {
                res = path;
            }
            // 注意2，这里一定需要反转回来, 还需要遍历到其它叶子节点.
            builder.reverse();
        }
        dfs(root.left, builder);
        dfs(root.right, builder);
        builder.deleteCharAt(builder.length() - 1);
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
