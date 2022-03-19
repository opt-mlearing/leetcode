package leetcode;

/**
 * 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class Solution746 {

    public int minCostClimbingStairs(int[] cost) {
        // dp[i]= min(dp[i- 1]+ cost[n- 1], dp[n- 2]+ cost[n- 2])
        // dp[i] 表示到达 i的最小费用
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; ++i) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }

}
