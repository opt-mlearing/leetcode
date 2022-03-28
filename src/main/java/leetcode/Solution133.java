package leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution133 {

    private Map<Node, Node> map = new HashMap<Node, Node>();

    public Node cloneGraph_bfs(Node node) {

        if (node == null) {
            return node;
        }
        Deque<Node> deque = new ArrayDeque<Node>();
        deque.offer(node);
        while (!deque.isEmpty()) {
            Node tmp = deque.pop();
            if (tmp == null) {
                return null;
            }
            if (map.containsKey(tmp)) {
                return map.get(tmp);
            }
            Node clone = new Node(tmp.val, new ArrayList<Node>());
            map.put(tmp, clone);
            for (Node subNode : tmp.neighbors) {
                clone.neighbors.add(cloneGraph_bfs(subNode));
            }
        }
        return map.get(node);
    }

    public Node cloneGraph_dfs(Node node) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node subNode : node.neighbors) {
            clone.neighbors.add(cloneGraph_dfs(subNode));
        }
        return clone;
    }

    private static class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}


