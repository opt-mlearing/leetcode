package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class SolutionOffer_54 {

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list);
        // 第k大== 第 N-k小，N等于节点总数量.
        return list.get(list.size() - k);
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

        TreeNode(int x) {
            val = x;
        }
    }

}
