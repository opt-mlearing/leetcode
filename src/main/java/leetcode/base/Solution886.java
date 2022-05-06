package leetcode.base;

/**
 * 886. 可能的二分法
 * https://leetcode-cn.com/problems/possible-bipartition/
 */
public class Solution886 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        UnionFind unionFind = new UnionFind(n * 2);
        for (int[] dislike : dislikes) {
            int x = dislike[0];
            int y = dislike[1];
            unionFind.union(x, y + n);
            unionFind.union(x + n, y);
            if (unionFind.connect(x, y) || unionFind.connect(x + n, y + n)) {
                return false;
            }
        }
        return true;
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
