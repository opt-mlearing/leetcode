package leetcode.base;

/**
 * 1319. 连通网络的操作次数
 * https://leetcode.cn/problems/number-of-operations-to-make-network-connected/
 *
 * @author: caogl
 * @date: 2022/7/23, 22:05
 **/
public class Solution1319 {

    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        int size = connections.length;
        if (size < n - 1) {
            return -1;
        }
        for (int i = 0; i < size; ++i) {
            int x = connections[i][0];
            int y = connections[i][1];
            unionFind.union(x, y);
        }
        int res = unionFind.count - 1;
        return res >= 0 ? res : -1;
    }

    private static class UnionFind {

        private int[] parent;
        private int count;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; ++i) {
                this.parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            parent[px] = py;
            count--;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }

    private int[] parent;
    private int num;

    public int makeConnected_1(int n, int[][] connections) {
        parent = new int[n];
        num = n;
        if (connections.length < n - 1) {
            return -1;
        }
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        int repeat = 0;
        for (int i = 0; i < connections.length; ++i) {
            int a = connections[i][0];
            int b = connections[i][1];
            if (find(a) != find(b)) {
                union(a, b);
            }
        }
        return num - 1;
    }

    private void union(int x, int y) {
        parent[find(x)] = find(y);
        num--;
    }

    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

}
