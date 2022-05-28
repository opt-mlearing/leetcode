package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 * https://leetcode.cn/problems/LwUNpT/
 */
public class SolutionOffer_II_045 {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        TreeNode buttomLeft = null;
        while (!stack.isEmpty()) {
            buttomLeft = stack.peekLast();
            TreeNode node = stack.poll();
            if (node.right != null) {
                stack.offer(node.right);
            }
            if (node.left != null) {
                stack.offer(node.left);
            }
        }
        return buttomLeft.val;
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
