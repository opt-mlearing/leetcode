package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二叉树中所有距离为 K 的结点
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class Solution863 {

    private List<Integer> res;
    private Map<Integer, TreeNode> mapping;

    // 分两步进行，第一步找到每个的节点的父节点.
    // 第二步再找距离为k的节点.
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        mapping = new HashMap<Integer, TreeNode>();
        res = new ArrayList<Integer>();
        findParent(root);
        findKDistance(target, null, 0, k);
        return res;
    }

    private void findKDistance(TreeNode target, TreeNode pre, int distance, int k) {
        if (target == null) {
            return;
        }
        if (distance == k) {
            res.add(target.val);
            return;
        }
        // 避免从父节出发，然后又回到原来的节点.
        if (target.left != pre) {
            findKDistance(target.left, target, distance + 1, k);
        }
        if (target.right != pre) {
            findKDistance(target.right, target, distance + 1, k);
        }
        TreeNode parent = mapping.get(target.val);
        if (parent != pre) {
            findKDistance(parent, target, distance + 1, k);
        }
    }

    private void findParent(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            mapping.put(root.left.val, root);
            findParent(root.left);
        }
        if (root.right != null) {
            mapping.put(root.right.val, root);
            findParent(root.right);
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
