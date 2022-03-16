package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树节点最小距离
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class Solution783 {

    // 注意，题目中二叉搜索树.
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> container = new ArrayList<Integer>();
        preSearch(root, container);
        if (container.size() < 2) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < container.size(); ++i) {
            res = Math.min(res, Math.abs(container.get(i) - container.get(i - 1)));
        }
        return res;
    }

    private void preSearch(TreeNode root, List<Integer> container) {
        if (root == null) {
            return;
        }
        preSearch(root.left, container);
        container.add(root.val);
        preSearch(root.right, container);
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
