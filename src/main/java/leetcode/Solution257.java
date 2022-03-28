package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {

    private List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, new String());
        return result;
    }

    private void dfs(TreeNode root, String pre) {
        if (root.left == null && root.right == null) {
            result.add(addStringValue(pre, root));
            return;
        }
        String str = addStringValue(pre, root);
        if (root.left != null) {
            dfs(root.left, str);
        }
        if (root.right != null) {
            dfs(root.right, str);
        }
    }

    private String addStringValue(String origin, TreeNode node) {
        if (node == null) {
            return origin;
        }
        StringBuffer buffer = new StringBuffer(origin);
        if (buffer.length() > 0) {
            buffer.append("->");
        }
        buffer.append(Integer.valueOf(node.val));
        return buffer.toString();
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
