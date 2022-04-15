package leetcode.base;

import java.util.ArrayList;
import java.util.List;

public class Solution530 {

    private int minInernal;
    private TreeNode preNode;

    /**
     * 增加一个pre节点，由于底下的实现是深度搜索，故此preNode是越底层的节点.
     * 搜索二叉树的中序号遍历为递增序列.
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {

        if (null == root) {
            return 0;
        }
        preNode = null;
        minInernal = Integer.MAX_VALUE;
        dfs(root);
        return minInernal;

    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (preNode == null) {
            preNode = root;
        } else {
            minInernal = Math.min(minInernal, root.val - preNode.val);
            preNode = root;
        }
        dfs(root.right);
    }

    /**
     * 朴素方法，通过递增队列的获取.
     * 搜索二叉树的中序号遍历为递增序列.
     *
     * @param root
     * @return
     */
    public int getMinimumDifference_by_order_array(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> container = new ArrayList<Integer>();
        innerSearch(root, container);
        int minVal = Integer.MAX_VALUE;
        if (container.size() < 2) {
            return 0;
        }
        for (int i = 0; i < container.size() - 1; ++i) {
            minVal = Math.min(minVal, container.get(i + 1) - container.get(i));
        }
        return minVal;
    }


    private void innerSearch(TreeNode node, List<Integer> container) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            container.add(node.val);
            return;
        }
        innerSearch(node.left, container);
        container.add(node.val);
        innerSearch(node.right, container);
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
