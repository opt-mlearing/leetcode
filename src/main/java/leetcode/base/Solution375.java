package leetcode.base;

/**
 * 375. 猜数字大小 II
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/
 */
public class Solution375 {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; --i) {
            for (int j = i + 1; j <= n; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }

}
