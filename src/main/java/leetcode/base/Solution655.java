package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输出二叉树
 * https://leetcode-cn.com/problems/print-binary-tree/
 */
public class Solution655 {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int height = findHeight(root);
        int width = (1 << height) - 1;
        for (int i = 0; i < height; ++i) {
            String[] sub = new String[width];
            Arrays.fill(sub, "");
            res.add(Arrays.asList(sub));
        }
        dfs(res, root, 0, 0, width);
        return res;
    }

    // 实际上利用啦中序遍历的特征，root在中间.
    private void dfs(List<List<String>> res, TreeNode root, int depth, int left, int right) {
        if (root == null) {
            return;
        }
        int mid = (left + right) >> 1;
        res.get(depth).set(mid, String.valueOf(root.val));
        dfs(res, root.left, depth + 1, left, mid - 1);
        dfs(res, root.right, depth + 1, mid + 1, right);
    }

    // 获得高度.
    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
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
