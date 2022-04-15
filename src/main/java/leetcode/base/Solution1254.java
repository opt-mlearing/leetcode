package leetcode.base;

/**
 * 统计封闭岛屿的数目
 * https://leetcode-cn.com/problems/number-of-closed-islands/
 */
public class Solution1254 {

    private int m;
    private int n;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // 先搜素边界
        for (int i = 0; i < m; ++i) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int i = 1; i < n - 1; ++i) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        // 与飞岛问题类似，这里需要针对封闭的岛屿再递归搜索一下.
        int res = 0;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                // 从一块陆地开始递归搜索.
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }

}
