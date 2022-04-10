package leetcode.typical;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.09. 二叉搜索树序列
 * https://leetcode-cn.com/problems/bst-sequences-lcci/
 */
public class Solution04_09 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<TreeNode> choose = new ArrayList<TreeNode>();
        choose.add(root);
        backtracking(choose, new ArrayList<Integer>());
        return res;
    }

    private void backtracking(List<TreeNode> choose, List<Integer> path) {
        // 是否便利到根.
        if (choose.isEmpty()) {
            res.add(new ArrayList<Integer>(path));
        }
        for (int i = 0; i < choose.size(); ++i) {
            TreeNode node = choose.get(i);
            choose.remove(i);
            if (node.left != null) {
                choose.add(node.left);
            }
            if (node.right != null) {
                choose.add(node.right);
            }
            path.add(node.val);
            backtracking(choose, path);
            path.remove(path.size() - 1);
            choose.add(i, node);
            if (node.left != null) {
                choose.remove(node.left);
            }
            if (node.right != null) {
                choose.remove(node.right);
            }
        }
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
