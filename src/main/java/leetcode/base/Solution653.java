package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数之和 IV - 输入 BST
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
public class Solution653 {

    // 注意，题目给的是二叉搜索树.
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> values = new ArrayList<Integer>();
        preOrder(root, values);
        int left = 0;
        int right = values.size() - 1;
        while (left < right) {
            int tmp = values.get(left) + values.get(right);
            if (tmp < k) {
                left++;
            } else if (tmp > k) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void preOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        preOrder(root.left, values);
        values.add(root.val);
        preOrder(root.right, values);
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
