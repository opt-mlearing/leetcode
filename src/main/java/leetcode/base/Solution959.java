package leetcode.base;

/**
 * 959. 由斜杠划分区域
 * https://leetcode.cn/problems/regions-cut-by-slashes/
 *
 * @author: caogl
 * @date: 2022/7/6, 3:20
 **/
public class Solution959 {

    public int regionsBySlashes(String[] grid) {
        int size = grid.length;
        int n = 4 * size * size;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < size; ++i) {
            // 方格内合并.
            for (int j = 0; j < size; ++j) {
                int index = 4 * (i * size + j);
                if (grid[i].charAt(j) == '/') {
                    unionFind.union(index, index + 3);
                    unionFind.union(index + 1, index + 2);
                } else if (grid[i].charAt(j) == '\\') {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 2, index + 3);
                } else {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 1, index + 2);
                    unionFind.union(index + 2, index + 3);
                }
                // 方格间合并.
                if (j + 1 < size) {
                    unionFind.union(index + 1, 4 * (i * size + j + 1) + 3);
                }
                if (i + 1 < size) {
                    unionFind.union(index + 2, 4 * ((i + 1) * size + j));
                }
            }
        }
        return unionFind.count;
    }

    private static class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int size) {
            this.count = size;
            this.parent = new int[size];
            for (int i = 0; i < size; ++i) {
                parent[i] = i;
            }
        }

        public int find(int n) {
            while (n != parent[n]) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                this.parent[px] = py;
                this.count--;
            }
        }
    }

}
