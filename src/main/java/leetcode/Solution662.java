package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树最大宽度
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class Solution662 {

    private int maxWidth;

    // 深度优先递归，需要优先左子树的左子节点.
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        maxWidth = 0;
        dfs(root, left, 1, 0);
        return maxWidth;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> left, int depth, int position) {
        if (root == null) {
            return;
        }
        // 这里利用了深度优先搜索的特性,全部左子节点可以被优先遍历到,left map中仅记录第一次遍历的左子节点.
        left.computeIfAbsent(depth, key -> position);
        maxWidth = Math.max(maxWidth, position - left.get(depth) + 1);
        dfs(root.left, left, depth + 1, position * 2);
        dfs(root.right, left, depth + 1, position * 2 + 1);
    }

    // 宽度优先搜索
    public int widthOfBinaryTree_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 首位置是0，不要填错了，其实也不影响后续计算.
        root.val = 0;
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offer(root);
        int width = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            // 前置判断，要不放在末尾，还需要加一个if(deque.size()> 0){...} 的判断，避免不必要的麻烦.
            width = Math.max(width, deque.peekLast().val - deque.peekFirst().val + 1);
            for (int i = 0; i < size; ++i) {
                TreeNode tmp = deque.poll();
                if (tmp.left != null) {
                    tmp.left.val = tmp.val * 2;
                    deque.offer(tmp.left);
                }
                if (tmp.right != null) {
                    tmp.right.val = tmp.val * 2 + 1;
                    deque.offer(tmp.right);
                }
            }
        }
        return width;
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
