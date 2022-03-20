package leetcode;

/**
 * 买卖股票的最佳时机 IV
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class Solution188 {

    public int maxProfit(int k, int[] prices) {
        // dp[i][0][j] 表示在第i天，没有购入股票，交易j次的 最大利润.
        // dp[i][1][j] 表示在第i天，购入股票，交易j次的 最大利润.
        // 其中 买入&& 卖出 算一个完整的交易，当买入的时候交易次数加1.
        int size = prices.length;
        if (size < 2) {
            return 0;
        }
        int kk = Math.min(k, size / 2);
        int[][][] dp = new int[size][2][kk + 1];
        // 这里的i是从第0天开始的.
        for (int i = 0; i <= kk; ++i) {
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }
        for (int i = 1; i < size; ++i) {
            for (int j = 1; j <= kk; ++j) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
            }
        }
        return dp[size - 1][0][kk];
    }

}
