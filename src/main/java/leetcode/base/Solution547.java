package leetcode.base;

/**
 * 547. 省份数量
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
public class Solution547 {

    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            if (unionFind.find(i) == i) {
                res++;
            }
        }
        return res;
    }

    private static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int xp = find(x);
            int yp = find(y);
            if (xp == yp) {
                return;
            }
            parent[xp] = yp;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }
    }

}
