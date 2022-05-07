package leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 110. 所有路径
 * https://leetcode-cn.com/problems/bP4bmD/
 */
public class SolutionOffer_II_110 {

    private int n;
    private List<List<Integer>> res;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offer(0);
        dfs(graph, 0, deque);
        return res;
    }

    private void dfs(int[][] graph, int start, Deque<Integer> path) {
        if (start == n - 1 && !path.isEmpty()) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int vertex : graph[start]) {
            path.offer(vertex);
            dfs(graph, vertex, path);
            path.pollLast();
        }
    }

}
