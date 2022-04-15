package leetcode.base;

/**
 * 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Solution309 {

    public int maxProfit(int[] prices) {
        // dp[i][0] 第i天 未持有股票 收益最大.
        // dp[i][1] 第i天 已持有股票 收益最大.
        // dp[i][2] 第i天 处于冷冻期 收益最大.
        int size = prices.length;
        if (size < 1) {
            return 0;
        }
        int[][] dp = new int[size][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < size; ++i) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][2]), dp[i - 1][1] + prices[i]);
            // 买股票的时候，除了第一天的股票，可以直接买，其他的都是从禁售期后开始的.
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][2]);
        }
        return Math.max(dp[size - 1][0], dp[size - 1][2]);
    }

}
