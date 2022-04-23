package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 802. 找到最终的安全状态
 * https://leetcode-cn.com/problems/find-eventual-safe-states/
 */
public class Solution802 {

    // 本题原意，找出度为0的顶点，反过来，出度0变成入度0.
    // 然后从出度为0的端点开始遍历图，入度位变0的端点就是安全点.
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] inDegree = new int[n];
        // 邻接矩阵.
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; ++i) {
            for (int vertex : graph[i]) {
                edges.get(vertex).add(i);
            }
            inDegree[i] = graph[i].length;
        }
        Deque<Integer> deuqe = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                deuqe.offer(i);
            }
        }
        while (!deuqe.isEmpty()) {
            for (int tmp : edges.get(deuqe.poll())) {
                if (--inDegree[tmp] == 0) {
                    deuqe.offer(tmp);
                }
            }
        }
        deuqe.clear();
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                deuqe.offer(i);
            }
        }
        return new ArrayList<Integer>(deuqe);
    }

}
