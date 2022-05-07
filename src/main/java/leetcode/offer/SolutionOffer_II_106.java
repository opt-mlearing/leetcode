package leetcode.offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 106. 二分图
 * https://leetcode-cn.com/problems/vEAB3K/
 * 对比dfs、bfs、union find, 性能依次降低.
 */
public class SolutionOffer_II_106 {

    // 宽度优先.
    public boolean isBipartite_bfs1(int[][] graph) {
        int n = graph.length;
        // 0表示未填色，1 && -1 分别表示一种颜色.
        // 1ms/ 41.8 MB
        int[] colors = new int[n];
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < graph.length; ++i) {
            if (colors[i] == 0) {
                deque.offer(i);
                colors[i] = 1;
                while (!deque.isEmpty()) {
                    int vertex = deque.poll();
                    int color = -colors[vertex];
                    for (int v : graph[vertex]) {
                        if (colors[v] == 0) {
                            deque.offer(v);
                            colors[v] = color;
                        } else if (colors[v] == -color) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // 宽度优先, 这个bfs写的有点问题.太长了.
    // 这个也留着 2ms/ 42.8MB
    public boolean isBipartite_bfs2(int[][] graph) {
        int n = graph.length;
        // 二分图，0表示未着色，1表示一种颜色，-1表示另一种颜色.
        int[] colors = new int[n];
        for (int i = 0; i < n; ++i) {
            if (colors[i] == 0) {
                Deque<Integer> stack = new LinkedList<Integer>();
                colors[i] = 1;
                for (int vertex : graph[i]) {
                    stack.offer(vertex);
                }
                int preColor = 1;
                while (!stack.isEmpty()) {
                    int size = stack.size();
                    for (int j = 0; j < size; ++j) {
                        int v = stack.poll();
                        if (colors[v] == 0) {
                            colors[v] = -preColor;
                            for (int v1 : graph[v]) {
                                // 这里减支一下.
                                if (colors[v1] == 0) {
                                    stack.offer(v1);
                                } else if (colors[v1] == -preColor) {
                                    return false;
                                } else if (colors[v1] == preColor) {
                                    continue;
                                }
                            }
                        } else if (colors[v] == preColor) {
                            return false;
                        }
                    }
                    preColor = -preColor;
                }
            }
        }
        return true;
    }

    private int[] colors;
    private boolean isValid;

    // 深度优先
    // 0ms/41.8MB, dfs is best.
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colors = new int[n];
        isValid = true;
        // -1表示未着色.
        Arrays.fill(colors, 0);
        for (int i = 0; i < n; ++i) {
            dfs(graph, i, 1);
        }
        return isValid;
    }

    private void dfs(int[][] graph, int start, int color) {
        if (colors[start] != 0) {
            return;
        }
        colors[start] = color;
        for (int vertex : graph[start]) {
            if (colors[vertex] == 0) {
                dfs(graph, vertex, -color);
                // 减枝，可提前减少递归深度.
                if (!isValid) {
                    return;
                }
            } else if (colors[vertex] == color) {
                isValid = false;
                return;
            }
        }
    }

    // 并查集
    // 3ms/ 42.3MB.
    public boolean isBipartite_uf(int[][] graph) {
        int n = graph.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; ++i) {
            int x = i;
            for (int j = 0; j < graph[i].length; ++j) {
                int y = graph[i][j];
                if (uf.isConnect(x, y)) {
                    return false;
                }
                if (j > 0) {
                    uf.union(graph[i][j - 1], y);
                }
            }
        }
        return true;
    }

    private static class UnionFind {
        private int[] parent;
        private int[] count;
        private int size;

        public UnionFind(int n) {
            parent = new int[n];
            count = new int[n];
            size = n;
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                count[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            if (count[px] < count[py]) {
                int tmp = px;
                px = py;
                py = tmp;
            }
            parent[py] = px;
            count[px] += count[py];
            size--;
        }
    }

}
