package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 1631. 最小体力消耗路径
 * https://leetcode-cn.com/problems/path-with-minimum-effort/submissions/
 */
public class Solution1631 {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // 依次获取相邻权, 以heights[i][j] 相临联通边为height[i- 1][j]&& heights[i][j- 1].
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int index = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{(i - 1) * n + j, index, Math.abs(heights[i - 1][j] - heights[i][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{i * n + (j - 1), index, Math.abs(heights[i][j - 1] - heights[i][j])});
                }
            }
        }
        edges.sort((arr1, arr2) -> Integer.compare(arr1[2], arr2[2]));
        UnionFind unionFind = new UnionFind(m * n);
        for (int i = 0; i < edges.size(); ++i) {
            int x = edges.get(i)[0];
            int y = edges.get(i)[1];
            unionFind.union(x, y);
            if (unionFind.isConnect(0, m * n - 1)) {
                return edges.get(i)[2];
            }
        }
        return 0;
    }

    private static class UnionFind {
        private int[] parent;
        private int[] nums;
        private int connectCount;

        public UnionFind(int n) {
            parent = new int[n];
            nums = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                nums[i] = 1;
            }
            connectCount = n;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            if (nums[px] > nums[py]) {
                parent[py] = px;
                nums[px] += nums[py];
            } else {
                parent[px] = py;
                nums[py] += nums[px];
            }
            // 成功合并之后，连通分量减1.
            connectCount--;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }
    }

}