package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 叶子相似的树
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class Solution872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        List<TreeNode> list2 = new ArrayList<TreeNode>();
        dfs(root1, list1);
        dfs(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); ++i) {
            if (list1.get(i).val != list2.get(i).val) {
                return false;
            }
        }
        return true;
    }

    // 先序遍历
    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root);
        }
        dfs(root.left, list);
        dfs(root.right, list);
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
