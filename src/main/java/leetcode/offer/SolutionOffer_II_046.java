package leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 046. 二叉树的右侧视图
 * https://leetcode.cn/problems/WNC0Lk/
 */
public class SolutionOffer_II_046 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            res.add(stack.peekLast().val);
            int size = stack.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = stack.poll();
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
