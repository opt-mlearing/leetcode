package leetcode.base;

/**
 * 飞地的数量
 * https://leetcode-cn.com/problems/number-of-enclaves/
 */
public class Solution1020 {

    private int m;
    private int n;
    private boolean[][] isVisit;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isVisit = new boolean[m][n];
        // 从边框开始搜索.
        for (int i = 0; i < m; ++i) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int i = 1; i < n - 1; ++i) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        // 统计不包含边框的岛屿数量.
        int res = 0;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (!isVisit[i][j] && grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || isVisit[i][j]) {
            return;
        }
        isVisit[i][j] = true;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

}
