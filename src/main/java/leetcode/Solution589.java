package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class Solution589 {

    private List<Integer> res;

    public List<Integer> preorder(Node root) {
        res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        dfs(root);
        return res;

    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node node : root.children) {
            dfs(node);
        }
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
