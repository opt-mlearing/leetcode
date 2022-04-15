package leetcode.base;

/**
 * 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 */
public class Solution518 {

    public int change(int amount, int[] coins) {
        // dp[i] 表示可以凑成金额i的组合数目.
        // dp[i]= dp[i]+ dp[i- coins[j]];
        int[] dp = new int[amount + 1];
        // 一个不取也是一种方式.
        dp[0] = 1;
        // 外层循环保证取硬币的顺序.
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j <= amount; ++j) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

}
