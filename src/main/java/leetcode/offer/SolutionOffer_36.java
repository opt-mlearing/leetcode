package leetcode.offer;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class SolutionOffer_36 {

    private Node head;
    private Node left;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = left;
        left.right = head;
        return head;

    }

    private void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (left == null) {
            head = node;
        } else {
            node.left = left;
            left.right = node;
        }
        left = node;
        dfs(node.right);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}
