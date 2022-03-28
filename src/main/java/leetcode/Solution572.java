package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 另一棵树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class Solution572 {

    private int maxElement = Integer.MIN_VALUE;
    private int leftLeaf = 0;
    private int rightLeaf = 0;


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        getMaxTreeNodeVal(root);
        getMaxTreeNodeVal(subRoot);
        leftLeaf = maxElement + 1;
        rightLeaf = maxElement + 2;
        List<Integer> rootList = new ArrayList<Integer>();
        preOrder(root, rootList);
        List<Integer> subList = new ArrayList<Integer>();
        preOrder(subRoot, subList);
        return kmp(rootList, subList);
    }

    private boolean kmp(List<Integer> text, List<Integer> pat) {
        // 不匹配的时候pat索引回滚的位置
        int[] fail = new int[pat.size()];
        Arrays.fill(fail, -1);
        for (int i = 1, j = -1; i < pat.size(); ++i) {
            while (j != -1 && !(pat.get(i).equals(pat.get(j + 1)))) {
                j = fail[j];
            }
            if (pat.get(i).equals(pat.get(j + 1))) {
                ++j;
            }
            fail[i] = j;
        }
        for (int i = 0, j = -1; i < text.size(); ++i) {
            while (j != -1 && !(text.get(i).equals(pat.get(j + 1)))) {
                j = fail[j];
            }
            if (text.get(i).equals(pat.get(j + 1))) {
                ++j;
            }
            if (j == pat.size() - 1) {
                return true;
            }
        }
        return false;
    }

    private void preOrder(TreeNode root, List<Integer> container) {
        if (root == null) {
            return;
        }
        container.add(root.val);
        if (root.left == null) {
            container.add(leftLeaf);
        } else {
            preOrder(root.left, container);
        }
        if (root.right == null) {
            container.add(rightLeaf);
        } else {
            preOrder(root.right, container);
        }
    }

    private void getMaxTreeNodeVal(TreeNode root) {
        if (root == null) {
            return;
        }
        maxElement = Math.max(maxElement, root.val);
        getMaxTreeNodeVal(root.left);
        getMaxTreeNodeVal(root.right);
    }

    public boolean isSubtree_greed(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
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
