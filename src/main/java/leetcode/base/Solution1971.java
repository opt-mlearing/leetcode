package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1971. 寻找图中是否存在路径
 * https://leetcode.cn/problems/find-if-path-exists-in-graph/
 *
 * @author caogaoli
 * @date 2022/7/14 13:20
 */
public class Solution1971 {

    // 并查集.
    // 看起来并查集的效率高.
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        int size = edges.length;
        for (int i = 0; i < size; ++i) {
            int[] edge = edges[i];
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.find(source) == unionFind.find(destination);
    }

    private static class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find_1(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int pX = find(x);
            int pY = find(y);
            if (pX == pY) {
                return;
            }
            parent[pY] = pX;
        }

    }

    // 这个实现效率真的低，哭了
    public boolean validPath_bfs(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        // 初始邻接边
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(new ArrayList<Integer>());
        }
        // 构建邻接边
        for (int[] item : edges) {
            list.get(item[0]).add(item[1]);
            list.get(item[1]).add(item[0]);
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offer(source);
        // 标记数组
        boolean[] isVisit = new boolean[n];
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                int tmp = deque.poll();
                if (isVisit[tmp]) {
                    continue;
                }
                isVisit[tmp] = true;
                List<Integer> subList = list.get(tmp);
                for (Integer element : subList) {
                    // 避免存在环，无限循环
                    if (isVisit[element]) {
                        continue;
                    }
                    if (element == destination) {
                        return true;
                    } else {
                        deque.offer(element);
                    }
                }
            }
        }
        return false;
    }

}
