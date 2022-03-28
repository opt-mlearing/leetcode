package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution337 {

    private Map<TreeNode, Integer> select = new HashMap<>();
    private Map<TreeNode, Integer> abandon = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(select.getOrDefault(root, 0), abandon.getOrDefault(root, 0));
    }

    // 深度优先搜索
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 注意这里必须先进行递归搜索，在select && abandon 这两个集合中完成左子节点&&右子节点数值的填充.
        dfs(root.left);
        dfs(root.right);
        // 这里的动态转移方程是：
        // 1）当root节点被选中时，root.left && root.right必然不能继续选中；
        // 2）当root节点不被选中时，root.left、root.right 分别可以被选中或者可以不被选中.
        select.put(root, root.val + abandon.getOrDefault(root.left, 0) + abandon.getOrDefault(root.right, 0));
        abandon.put(root, Math.max(select.getOrDefault(root.left, 0), abandon.getOrDefault(root.left, 0))
                + Math.max(select.getOrDefault(root.right, 0), abandon.getOrDefault(root.right, 0)));
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
