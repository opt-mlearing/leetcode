package leetcode.base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 404. 左叶子之和
 * https://leetcode.cn/problems/sum-of-left-leaves/
 */
public class Solution404 {

    // dfs
    public int sumOfLeftLeaves_dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null && isLeaf(root.left)) {
            res += root.left.val;
        } else {
            res += dfs(root.left);
        }
        // 这里对右子树可以做一下减枝.
        if (root.right != null && !isLeaf(root.right)) {
            res += dfs(root.right);
        }
        return res;
    }

    // bfs
    public int sumOfLeftLeaves_bfs(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = stack.poll();
                if (node.left != null) {
                    if (isLeaf(node.left)) {
                        res += node.left.val;
                    } else {
                        stack.offer(node.left);
                    }
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
            }
        }
        return res;
    }

    private boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    private int leftSum = 0;
    private Deque<TreeNode> deque = new ArrayDeque<TreeNode>();

    public int sumOfLeftLeaves_1(TreeNode root) {
        if ((root == null) || (root.left == null && root.right == null)) {
            return 0;
        }
        return doSumOfLeftLeaves(root.left, true) + doSumOfLeftLeaves(root.right, false);
    }

    private int doSumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }
        return doSumOfLeftLeaves(node.left, true) + doSumOfLeftLeaves(node.right, false);
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
