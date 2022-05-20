package leetcode.base;

import java.util.Arrays;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class Solution62 {

    // 二维dp
    public int uniquePaths_1(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
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
    public int uniquePaths_2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    // dfs 可能会超出时间限制.
    public int uniquePaths_3(int m, int n) {
        return dfs(0, 0, m, n);
    }

    private int dfs(int row, int column, int m, int n) {
        if (row < 0 || row >= m || column < 0 || column >= n) {
            return 0;
        }
        if (row == m - 1 && column == n - 1) {
            return 1;
        }
        int count = dfs(row + 1, column, m, n) + dfs(row, column + 1, m, n);
        return count;
    }

}
