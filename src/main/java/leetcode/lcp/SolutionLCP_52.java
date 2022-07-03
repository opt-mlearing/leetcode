package leetcode.lcp;

import java.util.TreeSet;

/**
 * LCP 52. 二叉搜索树染色
 * https://leetcode.cn/problems/QO5KpG/
 *
 * @author: caogl
 * @date: 2022/7/4, 0:32
 **/
public class SolutionLCP_52 {

    private TreeSet<Integer> set;

    public int getNumber(TreeNode root, int[][] ops) {
        set = new TreeSet<>();
        dfs(root);
        int size = ops.length;
        int res = 0;
        for (int i = size - 1; i >= 0; --i) {
            int color = ops[i][0];
            int left = ops[i][1];
            int right = ops[i][2];
            while (true) {
                Integer ceiling = set.ceiling(left);
                if (ceiling == null || ceiling > right) {
                    break;
                }
                set.remove(ceiling);
                if (color == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
