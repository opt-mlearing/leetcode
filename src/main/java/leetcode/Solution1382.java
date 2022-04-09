package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. 将二叉搜索树变平衡
 * https://leetcode-cn.com/problems/balance-a-binary-search-tree/
 */
public class Solution1382 {

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        innerOrder(root, list);
        if (list == null || list.size() == 0) {
            return null;
        }
        return buildTree(list, 0, list.size() - 1);
    }

    // 递归构建子树.
    private TreeNode buildTree(List<TreeNode> innerOrder, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = innerOrder.get(mid);
        root.left = buildTree(innerOrder, left, mid - 1);
        root.right = buildTree(innerOrder, mid + 1, right);
        return root;
    }

    // 中序遍历.
    private void innerOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        innerOrder(root.left, list);
        list.add(root);
        innerOrder(root.right, list);
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
