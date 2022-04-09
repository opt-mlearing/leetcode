package leetcode.offer;

/**
 * 剑指 Offer II 052. 展平二叉搜索树
 * https://leetcode-cn.com/problems/NYBBNL/
 */
public class SolutionOffer2_052 {

    private TreeNode pre;
    private TreeNode head;

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return head;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        // 注意，这里出来以后就需要立即将 node.left赋值成null.
        node.left = null;
        if (pre == null) {
            head = node;
        } else {
            pre.right = node;
        }
        pre = node;
        dfs(node.right);
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
