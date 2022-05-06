package leetcode.base;

/**
 * 785. 判断二分图
 * https://leetcode-cn.com/problems/is-graph-bipartite/
 */
public class Solution785 {

    public boolean isBipartite(int[][] graph) {
        UnionFind unionFind = new UnionFind(graph.length);
        for (int x = 0; x < graph.length; ++x) {
            int pre = -1;
            // 注意，要满足二分图的话，这里x与graph[x]中的元素一定分别属于两个集合. && graph[x]中的元素一定属于一个集合.
            for (int y : graph[x]) {
                if (unionFind.connect(x, y)) {
                    return false;
                }
                if (pre != -1) {
                    unionFind.union(pre, y);
                }
                pre = y;
            }
        }
        return true;
    }

    private static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            parent[px] = py;
        }

        public boolean connect(int x, int y) {
            return find(x) == find(y);
        }
    }

}
