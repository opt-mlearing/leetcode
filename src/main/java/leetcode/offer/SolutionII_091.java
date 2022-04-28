package leetcode.offer;

/**
 * 剑指 Offer II 091. 粉刷房子
 * https://leetcode-cn.com/problems/JEj789/
 */
public class SolutionII_091 {

    // dp需要分状态存储.
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        // dp[i][j] 表示第i排第j个颜色的成本最小.
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; ++i) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int tmp = Integer.MAX_VALUE;
                for (int k = 0; k < n; ++k) {
                    if (j != k) {
                        tmp = Math.min(tmp, dp[i - 1][k]);
                    }
                }
                dp[i][j] = tmp + costs[i][j];
            }
        }
        int res = dp[m - 1][0];
        for (int i = 1; i < n; ++i) {
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }

}
