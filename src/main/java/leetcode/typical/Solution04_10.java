package leetcode.typical;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.10. 检查子树
 * https://leetcode-cn.com/problems/check-subtree-lcci/
 */
public class Solution04_10 {

    // 先用前序遍历忏产生队列，在使用kmp比较.
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        perorder(t1, list1);
        perorder(t2, list2);
        return kmp(list1, list2);
    }

    // 使用kmp进行比较.
    private boolean kmp(List<String> text, List<String> pattern) {
        int[] next = new int[pattern.size()];
        next[0] = -1;
        for (int i = 1, j = -1; i < pattern.size(); ++i) {
            while (j != -1 && !pattern.get(i).equals(pattern.get(j + 1))) {
                j = next[j];
            }
            if (pattern.get(i).equals(pattern.get(j + 1))) {
                ++j;
            }
            next[i] = j;
        }
        for (int i = 0, j = -1; i < text.size(); ++i) {
            while (j != -1 && !text.get(i).equals(pattern.get(j + 1))) {
                j = next[j + 1];
            }
            if (text.get(i).equals(pattern.get(j + 1))) {
                ++j;
            }
            if (j == pattern.size() - 1) {
                return true;
            }
        }
        return false;
    }

    // 前序遍历.
    private void perorder(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("NULL");
            return;
        }
        list.add(String.valueOf(root.val));
        perorder(root.left, list);
        perorder(root.right, list);
    }

    // 递归
    public boolean checkSubTree_1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null ^ t2 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
        } else {
            return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
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
