package leetcode;

/**
 * 最大二叉树
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class Solution654 {

    // 题目中已经明确，不重复的数组
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        int index = getMaxIndex(nums, start, end);
        if (index == -1) {
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums, start, index);
        root.right = buildTree(nums, index + 1, end);
        return root;
    }

    private int getMaxIndex(int[] nums, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int maxIndex = start;
        for (int i = start; i < end; ++i) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static class TreeNode {
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
