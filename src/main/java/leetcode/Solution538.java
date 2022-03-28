package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class Solution538 {

    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preOrder(root, list);
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; --i) {
            TreeNode node = list.get(i);
            sum += node.val;
            node.val = sum;
        }
        return root;
    }

    // 前序遍历
    private void preOrder(TreeNode root, List<TreeNode> values) {
        if (root == null) {
            return;
        }
        preOrder(root.left, values);
        values.add(root);
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
