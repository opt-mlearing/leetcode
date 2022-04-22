package leetcode.lcp;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LCP 07. 传递信息
 * https://leetcode-cn.com/problems/chuan-di-xin-xi/submissions/
 */
public class SolutionLCP_07 {

    private int waySize = 0;

    // 深度搜索.
    public int numWays_dfs(int n, int[][] relation, int k) {
        waySize = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < relation.length; ++i) {
            graph.get(relation[i][0]).add(relation[i][1]);
        }
        dfs(0, n - 1, 0, k, graph);
        return waySize;
    }

    private void dfs(int start, int end, int step, int stepLimit, List<List<Integer>> graph) {
        // 停止条件：最多递归stepLimit次.
        if (step == stepLimit) {
            if (start == end) {
                waySize++;
            }
            return;
        }
        // 单层递归的逻辑.
        for (Integer i : graph.get(start)) {
            dfs(i, end, step + 1, stepLimit, graph);
        }
        // 入参明确，无返回值，需要一个全局变量记录可行线路条数.
    }

    // 宽度搜索.
    public int numWays_bfs(int n, int[][] relation, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        // 构建邻近矩阵.
        for (int i = 0; i < relation.length; ++i) {
            int from = relation[i][0];
            int to = relation[i][1];
            graph.get(to).add(from);
        }
        // 找到n-1，从n-1开发反推
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int in : graph.get(n - 1)) {
            deque.offer(in);
        }
        for (int i = 1; i < k; ++i) {
            if (deque.isEmpty()) {
                return 0;
            }
            int size = deque.size();
            for (int j = 0; j < size; ++j) {
                int to = deque.poll();
                for (int it : graph.get(to)) {
                    deque.offer(it);
                }
            }
        }
        int res = 0;
        while (!deque.isEmpty()) {
            if (deque.poll() == 0) {
                ++res;
            }
        }
        return res;
    }

}
