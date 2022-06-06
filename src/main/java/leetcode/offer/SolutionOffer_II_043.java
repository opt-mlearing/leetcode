package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 043. 往完全二叉树添加节点
 * https://leetcode.cn/problems/NaqhDT/
 */
public class SolutionOffer_II_043 {

    private TreeNode root;
    private Deque<TreeNode> buttomLevel;

    public SolutionOffer_II_043(TreeNode root) {
        this.root = root;
        this.buttomLevel = new LinkedList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            // record leaf TreeNode.
            if (node.left == null || node.right == null) {
                this.buttomLevel.offer(node);
            }
            if (node.left != null) {
                stack.offer(node.left);
            }
            if (node.right != null) {
                stack.offer(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode insert = new TreeNode(v);
        this.buttomLevel.offer(insert);
        TreeNode top = this.buttomLevel.peek();
        if (top.left == null) {
            top.left = insert;
        } else if (top.right == null) {
            top.right = insert;
            buttomLevel.poll();
        }
        return top.val;
    }

    public TreeNode get_root() {
        return this.root;
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
