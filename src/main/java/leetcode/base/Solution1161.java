package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1161. 最大层内元素和
 * https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/
 */
public class Solution1161 {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        int depth = 1;
        int res = 0;
        int sum = Integer.MIN_VALUE;
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int levelSum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = deque.poll();
                levelSum += node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            if (sum < levelSum) {
                res = depth;
                sum = levelSum;
            }
            depth++;
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
