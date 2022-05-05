package leetcode.base;

/**
 * 684. 冗余连接
 * https://leetcode-cn.com/problems/redundant-connection/
 */
public class Solution684 {

    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; ++i) {
            if (find(edges[i][0]) != find(edges[i][1])) {
                union(edges[i][0], edges[i][1]);
            } else {
                return edges[i];
            }
        }
        return new int[0];
    }

    private void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

}
