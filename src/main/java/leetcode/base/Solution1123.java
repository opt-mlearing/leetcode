package leetcode.base;

/**
 * 1123. 最深叶节点的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
public class Solution1123 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Record dfs(TreeNode root) {
        if (root == null) {
            return new Record(0, null);
        }
        Record left = dfs(root.left);
        Record right = dfs(root.right);
        if (left.depth > right.depth) {
            return new Record(left.depth + 1, left.node);
        } else if (left.depth < right.depth) {
            return new Record(right.depth + 1, right.node);
        }
        return new Record(left.depth + 1, root);
    }

    private static class Record {
        private int depth;
        private TreeNode node;

        public Record(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    // 多次循环迭代，反复求高度.
    public TreeNode lcaDeepestLeaves_1(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == right) {
            return root;
        } else if (left < right) {
            return lcaDeepestLeaves(root.right);
        }
        return lcaDeepestLeaves(root.left);
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
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
