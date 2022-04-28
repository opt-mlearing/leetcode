package leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer II 103. 最少的硬币数目
 * https://leetcode-cn.com/problems/gaM7Ch/
 */
public class SolutionOffer_II_103 {

    // 外层货物-内层背包
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // 金额为0, 0枚硬币.
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i <= amount; ++i) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // 外层背包-内层货物
    public int coinChange_1(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
