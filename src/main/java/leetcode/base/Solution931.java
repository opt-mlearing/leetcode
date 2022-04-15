package leetcode.base;

/**
 * 下降路径最小和
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 */
public class Solution931 {

    public int minFallingPathSum(int[][] matrix) {
        // dp[i][j]= matrix[i][j]+ min(dp[i-1][j], dp[i-1][j- 1], dp[i- 1][j+ 1])
        // 注意边界
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; ++i) {
            dp[i][0] = matrix[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            for (int j = 1; j < n - 1; ++j) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
            }
            if (n >= 2) {
                dp[i][n - 1] = matrix[i][n - 1] + Math.min(dp[i - 1][n - 2], dp[i - 1][n - 1]);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }

}
