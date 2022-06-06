package leetcode.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTIterator {

    private List<TreeNode> list;
    private Iterator<TreeNode> iterator;

    public BSTIterator(TreeNode root) {
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
