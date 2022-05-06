package leetcode.base;

/**
 * 685. 冗余连接 II
 * https://leetcode-cn.com/problems/redundant-connection-ii/
 */
public class Solution685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] ancestor = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            ancestor[i] = i;
        }
        UnionFind unionFind = new UnionFind(n);
        int dIndegreeIndex = -1;
        int circleIndex = -1;
        for (int i = 0; i < n; ++i) {
            int par = edges[i][0];
            int chil = edges[i][1];
            if (ancestor[chil] != chil) {
                dIndegreeIndex = i;
            } else {
                ancestor[chil] = par;
                if (unionFind.connect(par, chil)) {
                    circleIndex = i;
                } else {
                    unionFind.union(par, chil);
                }
            }
        }
        if (dIndegreeIndex == -1) {
            return edges[circleIndex];
        } else {
            if (circleIndex == -1) {
                return edges[dIndegreeIndex];
            } else {
                int[] edge = edges[dIndegreeIndex];
                return new int[]{ancestor[edge[1]], edge[1]};
            }
        }
    }

    private static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        private boolean connect(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            parent[px] = py;
        }
    }

}
