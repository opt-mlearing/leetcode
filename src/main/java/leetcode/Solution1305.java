package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 两棵二叉搜索树中的所有元素
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */
public class Solution1305 {

    private List<Integer> res = null;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        res = new ArrayList<Integer>();
        List<Integer> sub1 = new ArrayList<Integer>();
        List<Integer> sub2 = new ArrayList<Integer>();
        dfs(root1, sub1);
        dfs(root2, sub2);
        mergeList(sub1, sub2);
        return res;
    }

    private void mergeList(List<Integer> list1, List<Integer> list2) {
        int len1 = list1.size();
        int len2 = list2.size();
        int l1 = 0;
        int l2 = 0;
        while (l1 < list1.size() && l2 < list2.size()) {
            if (list1.get(l1) < list2.get(l2)) {
                res.add(list1.get(l1));
                l1++;
            } else {
                res.add(list2.get(l2));
                l2++;
            }
        }
        if (l1 < list1.size()) {
            res.addAll(list1.subList(l1, list1.size()));
        } else if (l2 < list2.size()) {
            res.addAll(list2.subList(l2, list2.size()));
        }
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
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
