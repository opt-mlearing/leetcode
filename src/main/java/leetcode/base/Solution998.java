package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 998. 最大二叉树 II
 * https://leetcode-cn.com/problems/maximum-binary-tree-ii/
 */
public class Solution998 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        List<Integer> list = new ArrayList<Integer>();
        innerorder(root, list);
        list.add(val);
        return dfs(list, 0, list.size());
    }

    // right 是获取不到的.
    private TreeNode dfs(List<Integer> list, int left, int right) {
        if (left >= right) {
            return null;
        }
        int index = maxValueIndex(list, left, right);
        TreeNode root = new TreeNode(list.get(index));
        root.left = dfs(list, left, index);
        root.right = dfs(list, index + 1, right);
        return root;
    }

    // 找到最大数值对应索引号.
    private int maxValueIndex(List<Integer> list, int left, int right) {
        int maxIndex = left;
        for (int i = left + 1; i < right; ++i) {
            if (list.get(i) > list.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // 中序遍历，获取原数组
    private void innerorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        innerorder(root.left, list);
        list.add(root.val);
        innerorder(root.right, list);
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
