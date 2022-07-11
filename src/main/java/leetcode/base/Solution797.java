package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * https://leetcode.cn/problems/all-paths-from-source-to-target/
 *
 * @author: caogl
 * @date: 2022/7/12, 1:08
 **/
public class Solution797 {

    private List<List<Integer>> res;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<List<Integer>>();
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.offer(0);
        dfs(graph, 0, graph.length - 1, stack);
        return res;
    }

    public void dfs(int[][] graph, int index, int n, Deque<Integer> stack) {
        if (index == n) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int item : graph[index]) {
            stack.offer(item);
            dfs(graph, item, n, stack);
            stack.pollLast();
        }
    }

}
