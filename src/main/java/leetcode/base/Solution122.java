package leetcode.base;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author: caogl
 * @date: 2022/6/29, 0:05
 **/
public class Solution122 {

    public int maxProfit(int[] prices) {
        int size = prices.length;
        // 前一天手里无股票.
        int res0 = 0;
        // 前一天手里有股票.
        int res1 = -prices[0];
        for (int i = 1; i < size; ++i) {
            int nres0 = Math.max(res0, res1 + prices[i]);
            int nres1 = Math.max(res1, res0 - prices[i]);
            res0 = nres0;
            res1 = nres1;
        }
        return res0;
    }

    public int maxProfit_1(int[] prices) {
        // dp[i][0] 表示第i天无股票最大收益
        // dp[i][1] 表示第i天有股票最大收益
        int size = prices.length;
        int[][] dp = new int[size][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < size; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[size - 1][0];
    }

}
