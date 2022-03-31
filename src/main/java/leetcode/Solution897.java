package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 递增顺序搜索树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class Solution897 {

    private TreeNode currNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        currNode = dummy;
        innerOrder(root);
        return dummy.right;
    }

    // 中序遍历.
    private void innerOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        innerOrder(root.left);
        // 左节点置空.
        root.left = null;
        // 连接到先导节点的右边.
        currNode.right = root;
        // 再将当节点传递给先导节点.
        currNode = root;
        innerOrder(root.right);
    }

    // leetcode 平台运行不通过，本地是通过的，有点奇怪.
    public TreeNode increasingBST_error(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        preOrder(root, deque);
        return deque.peek();

    }

    private void preOrder(TreeNode root, Deque<TreeNode> deque) {
        if (root == null) {
            return;
        }
        preOrder(root.left, deque);
        if (!deque.isEmpty()) {
            TreeNode pre = deque.peekLast();
            pre.left = null;
            pre.right = root;
        }
        deque.offer(root);
        preOrder(root.right, deque);
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
