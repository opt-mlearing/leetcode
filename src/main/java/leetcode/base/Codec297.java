package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec297 {

    // Encodes a tree to a single string. 这里先采用前序遍历的方式，遍历搜索整颗树.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builer = new StringBuilder();
        preOrder(root, builer);
        return builer.toString().substring(0, builer.length() - 1);
    }

    private void preOrder(TreeNode root, StringBuilder builer) {
        if (root == null) {
            builer.append("NULL,");
            return;
        }
        builer.append(root.val).append(",");
        preOrder(root.left, builer);
        preOrder(root.right, builer);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals(",") || data.isEmpty()) {
            return null;
        }
        String[] datas = data.split(",");
        Deque<String> deque = new LinkedList<String>();
        for (String element : datas) {
            deque.offer(element);
        }
        return dfs(deque);
    }

    private TreeNode dfs(Deque<String> deque) {
        if (deque.isEmpty()) {
            return null;
        }
        String dataStr = deque.poll();
        if (dataStr.equals("NULL")) {
            return null;
        }
        Integer data = Integer.parseInt(dataStr);
        TreeNode root = new TreeNode(data);
        root.left = dfs(deque);
        root.right = dfs(deque);
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
