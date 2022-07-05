package leetcode.base;

/**
 * 931. 下降路径最小和
 * https://leetcode.cn/problems/minimum-falling-path-sum/
 *
 * @author: caogl
 * @date: 2022/7/6, 0:16
 **/
public class Solution931 {

    public int minFallingPathSum(int[][] matrix) {
        // dp[i][j]= matrix[i][j]+ min(dp[i-1][j], dp[i-1][j- 1], dp[i- 1][j+ 1])
        // 注意边界
        int n = matrix.length;
        int[][] dp = new int[n][n];
        // 初始化第一行.
        for (int i = 0; i < n; ++i) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; ++i) {
            // 每行首列元素.
            dp[i][0] = matrix[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            for (int j = 1; j < n - 1; ++j) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
            }
            // 每行最后一列元素.
            if (n >= 2) {
                dp[i][n - 1] = matrix[i][n - 1] + Math.min(dp[i - 1][n - 2], dp[i - 1][n - 1]);
            }
        }
        int res = dp[n - 1][0];
        for (int i = 1; i < n; ++i) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }

}
