package leetcode.base;

import java.util.Arrays;

/**
 * 62. 不同路径
 * https://leetcode.cn/problems/unique-paths/
 *
 * @author: caogl
 * @date: 2022/7/8, 1:13
 **/
public class Solution62 {

    private static final int[][] direction = {{0, -1}, {-1, 0}};

    // 递归+ 记忆化搜索.
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        return dfs(m - 1, n - 1, memo, m, n);
    }

    private int dfs(int x, int y, Integer[][] memo, int m, int n) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (x == 0 || y == 0) {
            return 1;
        }
        if (memo[x][y] != null) {
            return memo[x][y];
        }
        int count = 0;
        for (int i = 0; i < direction.length; ++i) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                count += dfs(nx, ny, memo, m, n);
            }
        }
        memo[x][y] = count;
        return count;
    }

    // 二维dp
    public int uniquePaths_2(int m, int n) {
        int[][] dp = new int[m][n];
        // dp[i][j]= dp[i- 1][j]+ dp[i][j- 1];
        // 注意边界.
        for (int i = 0; i < n; ++i) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 一维dp
    public int uniquePaths_1(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
