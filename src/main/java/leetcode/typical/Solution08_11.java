package leetcode.typical;

/**
 * 面试题 08.11. 硬币
 * https://leetcode-cn.com/problems/coin-lcci/
 */
public class Solution08_11 {

    private static final int[] prices = {1, 5, 10, 25};

    public int waysToChange(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // 0也是一种分法
        dp[0] = 1;
        // 观察示例答案，要的是组合.
        for (int i = 0; i < prices.length; ++i) {
            for (int j = prices[i]; j <= n; ++j) {
                dp[j] = (dp[j] + dp[j - prices[i]]) % 1000000007;
            }
        }
        return dp[n];
    }

}
