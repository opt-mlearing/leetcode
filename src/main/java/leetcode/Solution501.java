package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class Solution501 {

    private int base = 0;
    private int curCount = 0;
    private int globalCount = 0;
    private List<Integer> list = new ArrayList<Integer>();

    // 注意二叉搜索树的性质，若是一颗二叉搜索树，那么其中序遍历结果是一个非减队列.
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        dfs(root);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        addMax(root.val);
        dfs(root.right);
    }

    private void addMax(int val) {
        if (val == base) {
            curCount++;
        } else {
            curCount = 1;
            base = val;
        }
        if (curCount > globalCount) {
            list.clear();
            list.add(val);
        } else if (curCount == globalCount) {
            list.add(val);
        }
        globalCount = Math.max(globalCount, curCount);
    }

    public class TreeNode {
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
