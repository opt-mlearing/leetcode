package leetcode.lcp;

import java.util.HashSet;
import java.util.Set;

/**
 * LCP 44. 开幕式焰火
 * https://leetcode-cn.com/problems/sZ59z6/
 */
public class SolutionLCP_44 {

    private Set<Integer> set = null;

    public int numColor(TreeNode root) {
        set = new HashSet<Integer>();
        dfs(root);
        return set.size();
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
