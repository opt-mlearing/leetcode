package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter919 {

    private TreeNode root;
    // 使用栈缓存.
    private Deque<TreeNode> deque;

    public CBTInserter919(TreeNode root) {
        this.root = root;
        this.deque = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        // BFS to populate deque
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 从上到下，从左往右依次遍历，寻找可插入的位置.
            // 当前节点存在0或1个节点时，表示还有可插入位置，则加入栈中.
            if (node.left == null || node.right == null) {
                this.deque.offerLast(node);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    // 需要从栈中获取第一个节点，
    // 若该元素在插入新节点后无剩余位置，则将该节点彻底出栈，若仍然有剩余则不变.
    // 最后将新插入节点放到栈地.
    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        this.deque.offerLast(new TreeNode(v));
        if (node.left == null) {
            node.left = this.deque.peekLast();
        } else {
            node.right = this.deque.peekLast();
            // 已经没有位置了，完全弹出栈.
            deque.pollFirst();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return this.root;
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
