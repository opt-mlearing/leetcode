package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;

/**
 * 310. 最小高度树
 * https://leetcode-cn.com/problems/minimum-height-trees/
 */
public class Solution310 {

    // 使用拓扑排序方法.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        // 邻接矩阵
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjacent.add(new ArrayList<Integer>());
        }
        // 入度表
        int[] degree = new int[n];
        for (int[] item : edges) {
            int p = item[0];
            int q = item[1];
            adjacent.get(p).add(q);
            adjacent.get(q).add(p);
            degree[p]++;
            degree[q]++;
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1) {
                deque.offer(i);
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        int remand = n;
        while (remand > 2) {
            int size = deque.size();
            remand -= size;
            for (int i = 0; i < size; ++i) {
                int tmp = deque.poll();
                for (Integer vertex : adjacent.get(tmp)) {
                    degree[vertex]--;
                    if (degree[vertex] == 1) {
                        deque.offer(vertex);
                    }
                }
            }
        }
        return new ArrayList<Integer>(deque);
    }

}
