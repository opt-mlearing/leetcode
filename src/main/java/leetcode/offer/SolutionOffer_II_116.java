package leetcode.offer;

/**
 * 剑指 Offer II 116. 省份数量
 * https://leetcode-cn.com/problems/bLyHh0/
 */
public class SolutionOffer_II_116 {

    private int[] parent;
    private int[] size;

    // 已经明确是n* n 的矩阵.
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (find(i) == i) {
                ++res;
            }
        }
        return res;
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return;
        }
        if (size[px] < size[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

}
