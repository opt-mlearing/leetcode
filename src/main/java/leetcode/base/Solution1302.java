package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1302. 层数最深叶子节点的和
 * https://leetcode-cn.com/problems/deepest-leaves-sum/
 */
public class Solution1302 {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(root);
        int res = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int sum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = deque.poll();
                sum += node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            if (deque.isEmpty()) {
                res = sum;
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
