package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1302. 层数最深叶子节点的和
 * https://leetcode-cn.com/problems/deepest-leaves-sum/
 */
public class Solution1302 {

    private int res;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = maxDepth(root);
        res = 0;
        dfs(root, 1, maxDepth);
        return res;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private void dfs(TreeNode root, int depth, int maxDepth) {
        if (root == null) {
            return;
        }
        if (depth == maxDepth) {
            res += root.val;
        }
        dfs(root.left, depth + 1, maxDepth);
        dfs(root.right, depth + 1, maxDepth);
    }

    // bfs
    public int deepestLeavesSum_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        int res = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            res = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = stack.poll();
                res += node.val;
                if (node.left != null) {
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
            }
        }
        return res;
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
