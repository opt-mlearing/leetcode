package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的完全性检验
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 */
public class Solution958 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<Position> list = new ArrayList<Position>();
        list.add(new Position(root, 1));
        int index = 0;
        while (index < list.size()) {
            Position up = list.get(index);
            if (up.node != null) {
                list.add(new Position(up.node.left, up.position * 2));
                list.add(new Position(up.node.right, up.position * 2 + 1));
            }
            ++index;
        }
        return list.get(list.size() - 1).position == list.size();
    }

    private static class Position {
        TreeNode node;
        int position;

        public Position(TreeNode node, int position) {
            this.node = node;
            this.position = position;
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
