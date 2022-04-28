package leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 * https://leetcode-cn.com/problems/opLdQZ/
 */
public class SolutionOffer_II_056 {

    private Set<Integer> valueSet = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (valueSet.contains(k - root.val)) {
            return true;
        }
        valueSet.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
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
