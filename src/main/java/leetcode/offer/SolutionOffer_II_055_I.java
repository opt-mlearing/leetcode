package leetcode.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 剑指 Offer II 055. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/kTOapQ/
 *
 * @author: caogl
 * @date: 2022/7/8, 1:01
 **/
public class SolutionOffer_II_055_I {

    private List<TreeNode> list;
    private Iterator<TreeNode> iterator;

    public SolutionOffer_II_055_I(TreeNode root) {
        list = new ArrayList<TreeNode>();
        innerOrder(root);
        iterator = list.iterator();
    }

    private void innerOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        innerOrder(node.left);
        list.add(node);
        innerOrder(node.right);
    }

    public int next() {
        return iterator.next().val;
    }

    public boolean hasNext() {
        return iterator.hasNext();
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
