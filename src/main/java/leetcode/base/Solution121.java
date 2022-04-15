package leetcode.base;

/**
 * 买卖股票的最佳时机.
 *
 * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }

}
