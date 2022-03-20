package leetcode;

/**
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class Solution62 {

    public int uniquePaths(int m, int n) {
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

}
