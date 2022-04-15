package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 序列化和反序列化二叉搜索树
 * https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
 */
public class Codec449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        postOrder(root, builder);
        return builder.subSequence(0, builder.length() - 1).toString();
    }

    // 后序遍历.
    private void postOrder(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("NULL,");
            return;
        }
        postOrder(root.left, builder);
        postOrder(root.right, builder);
        builder.append(root.val).append(",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("") || data.equals(",")) {
            return null;
        }
        String[] datas = data.split(",");
        Deque<String> deque = new LinkedList<String>();
        for (String elemnt : datas) {
            deque.push(elemnt);
        }
        return dfs(deque);
    }

    // 注意，从后往前，先right后left.
    private TreeNode dfs(Deque<String> deque) {
        if (deque.isEmpty()) {
            return null;
        }
        String str = deque.pop();
        if (str.equals("NULL")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.right = dfs(deque);
        root.left = dfs(deque);
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
