package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 055. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/kTOapQ/
 *
 * @author: caogl
 * @date: 2022/7/8, 1:01
 **/
public class SolutionOffer_II_055_II {

    private List<Integer> list = null;
    private int pointer;

    public SolutionOffer_II_055_II(TreeNode root) {
        list = new ArrayList<Integer>();
        innerOrder(root, list);
        pointer = 0;
    }

    public int next() {
        if (hasNext()) {
            return list.get(pointer++);
        }
        return -1;
    }

    public boolean hasNext() {
        return pointer < list.size();
    }

    private void innerOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        innerOrder(node.left, list);
        list.add(node.val);
        innerOrder(node.right, list);
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

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */