package leetcode.base;

/**
 * 746. 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class Solution746 {

    public int minCostClimbingStairs(int[] cost) {
        // dp[i]= min(dp[i- 1]+ cost[n- 1], dp[n- 2]+ cost[n- 2])
        // dp[i] 表示到达 i的最小费用
        int size = cost.length;
        int[] dp = new int[size + 1];
        // 第0和第1台阶花费为0.
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= size; ++i) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[size];
    }

}
