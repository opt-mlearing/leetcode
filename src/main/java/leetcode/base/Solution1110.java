package leetcode.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1110. 删点成林
 * https://leetcode-cn.com/problems/delete-nodes-and-return-forest/
 */
public class Solution1110 {

    private Set<Integer> set = new HashSet<Integer>();
    private List<TreeNode> list = new ArrayList<TreeNode>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int item : to_delete) {
            set.add(item);
        }
        TreeNode node = dfs(root);
        if (node != null) {
            list.add(node);
        }
        return list;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (!set.contains(root.val)) {
            root.left = dfs(root.left);
            root.right = dfs(root.right);
            return root;
        } else {
            TreeNode left = dfs(root.left);
            if (left != null) {
                list.add(left);
            }
            TreeNode right = dfs(root.right);
            if (right != null) {
                list.add(right);
            }
            return null;
        }
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
