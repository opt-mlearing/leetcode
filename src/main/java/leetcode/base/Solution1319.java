package leetcode.base;

/**
 * 1319. 连通网络的操作次数
 * https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
 */
public class Solution1319 {

    private int[] parent;
    private int num;

    public int makeConnected(int n, int[][] connections) {
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
