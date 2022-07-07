package leetcode.base;

/**
 * 64. 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/
 *
 * @author: caogl
 * @date: 2022/7/8, 2:14
 **/
public class Solution64 {

    private static final int[][] direction = {{0, -1}, {-1, 0}};

    // 递归+ 记忆化搜索.
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] memo = new Integer[m][n];
        return dfs(grid, m - 1, n - 1, m, n, memo);
    }

    private int dfs(int[][] grid, int x, int y, int m, int n, Integer[][] memo) {
        if (x == 0 && y == 0) {
            return grid[0][0];
        }
        if (memo[x][y] != null) {
            return memo[x][y];
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < direction.length; ++i) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                count = Math.min(count, dfs(grid, nx, ny, m, n, memo));
            }
        }
        count += grid[x][y];
        memo[x][y] = count;
        return count;
    }

    // 网格dp, 二维dp
    public int minPathSum_dp(int[][] grid) {
        // dp[i][j]= grid[i][j]+ min(dp[i- 1][j], dp[i][j- 1]);
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < n; ++i) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

}
