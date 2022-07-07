package leetcode.base;

/**
 * 63. 不同路径 II
 * https://leetcode.cn/problems/unique-paths-ii/
 *
 * @author: caogl
 * @date: 2022/7/8, 1:46
 **/
public class Solution63 {

    private static final int[][] direction = {{0, -1}, {-1, 0}};

    // 递归+ 记忆化搜索.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] memo = new Integer[m][n];
        memo[0][0] = 1;
        for (int i = 1; i < m; ++i) {
            if ((obstacleGrid[i][0] == 0)) {
                memo[i][0] = memo[i - 1][0];
            } else {
                memo[i][0] = 0;
                ;
            }
        }
        for (int i = 1; i < n; ++i) {
            if ((obstacleGrid[0][i] == 0)) {
                memo[0][i] = memo[0][i - 1];
            } else {
                memo[0][i] = 0;
            }
        }
        return dfs(m - 1, n - 1, memo, obstacleGrid, m, n);
    }

    private int dfs(int x, int y, Integer[][] memo, int[][] obstacleGrid, int m, int n) {
        if (x < 0 || y < 0 || obstacleGrid[x][y] == 1) {
            return 0;
        }
        if (memo[x][y] != null) {
            return memo[x][y];
        }
        int count = 0;
        for (int i = 0; i < direction.length; ++i) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && obstacleGrid[nx][ny] == 0) {
                count += dfs(nx, ny, memo, obstacleGrid, m, n);
            }
        }
        memo[x][y] = count;
        return count;
    }

    // 二维dp
    public int uniquePathsWithObstacles_dp(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i < m; ++i) {
            if ((obstacleGrid[i][0] == 0)) {
                dp[i][0] = dp[i - 1][0];
            } else {
                break;
            }
        }
        for (int i = 1; i < n; ++i) {
            if ((obstacleGrid[0][i] == 0)) {
                dp[0][i] = dp[0][i - 1];
            } else {
                break;
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
