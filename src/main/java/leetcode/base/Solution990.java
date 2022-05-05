package leetcode.base;

/**
 * 990. 等式方程的可满足性
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 */
public class Solution990 {

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int x = str.charAt(0) - 'a';
                int y = str.charAt(3) - 'a';
                unionFind.union(x, y);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int x = str.charAt(0) - 'a';
                int y = str.charAt(3) - 'a';
                boolean connect = unionFind.isConnect(x, y);
                if (connect) {
                    return false;
                }
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

        public void union(int x, int y) {
            int pX = find(x);
            int pY = find(y);
            if (pX == pY) {
                return;
            }
            parent[pX] = pY;
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
