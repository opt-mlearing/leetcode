package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 * https://leetcode.cn/problems/flip-binary-tree-to-match-preorder-traversal/
 *
 * @author: caogl
 * @date: 2022/7/13, 22:36
 **/
public class Solution971 {

    private List<Integer> flipped;
    private int index;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.flipped = new ArrayList();
        this.index = 0;
        dfs(root, voyage);
        if (flipped.size() > 0 && flipped.get(0) == -1) {
            flipped.clear();
            flipped.add(-1);
        }
        return flipped;
    }

    public void dfs(TreeNode node, int[] voyage) {
        if (node != null) {
            if (node.val != voyage[index++]) {
                flipped.clear();
                flipped.add(-1);
                return;
            }
            // 如果发现root的left&right的val与 voyage对应不上，则旋转一下.
            if (index < voyage.length && node.left != null && node.left.val != voyage[index]) {
                flipped.add(node.val);
                dfs(node.right, voyage);
                dfs(node.left, voyage);
            } else {
                dfs(node.left, voyage);
                dfs(node.right, voyage);
            }
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
