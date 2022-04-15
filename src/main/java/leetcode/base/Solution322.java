package leetcode.base;

import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示金额为i时，做小的硬币数量.
        // dp[i]= min(dp[i]{不放}, dp[i- coins[j]]+ 1{放})
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            // 相同面额的硬币可以重复放入.
            for (int j = 0; j < coins.length; ++j) {
                // 避免越界，还有就是i>= coins[j] 才有考虑的意义.
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
