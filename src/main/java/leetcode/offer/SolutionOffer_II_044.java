package leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 044. 二叉树每层的最大值
 * https://leetcode.cn/problems/hPov7L/
 */
public class SolutionOffer_II_044 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            int val = Integer.MIN_VALUE;
            for (int i = 0; i < size; ++i) {
                TreeNode node = stack.poll();
                val = Math.max(val, node.val);
                if (node.left != null) {
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
            }
            res.add(val);
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
