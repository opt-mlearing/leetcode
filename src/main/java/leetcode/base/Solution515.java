package leetcode.base;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 在每个树行中找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class Solution515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        bfs(root, list);
        return list;
    }

    private void bfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < len; ++i) {
                TreeNode node = deque.poll();
                maxVal = Math.max(maxVal, node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            list.add(maxVal);
        }
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
