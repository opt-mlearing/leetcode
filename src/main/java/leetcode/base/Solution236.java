package leetcode.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author caogaoli
 * @date 2022/7/12 13:25
 */
public class Solution236 {

    private TreeNode res;

    // 递归
    // 6ms/ 42.9mb
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isDFS(root, p, q);
        return res;
    }

    private boolean isDFS(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean isLeft = isDFS(root.left, p, q);
        boolean isRight = isDFS(root.right, p, q);
        if ((isLeft && isRight) || ((isLeft || isRight) && (root.val == p.val || root.val == q.val))) {
            res = root;
        }
        return isLeft || isRight || (root.val == p.val || root.val == q.val);
    }


    private Map<Integer, TreeNode> parent;
    private Set<Integer> visited;

    // 存储父亲节点
    // 10ms/ 44.2mb
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        parent = new HashMap<Integer, TreeNode>();
        dfs(root);
        visited = new HashSet<Integer>();
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (!visited.add(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    // 递归
    // 6ms/43.1mb
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
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
