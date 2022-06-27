package leetcode.base;

/**
 * 746. 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @author: caogl
 * @date: 2022/6/28, 0:04
 **/
public class Solution746 {

    // dfs+ 记忆化搜索.
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        Integer[] memo = new Integer[size + 1];
        memo[0] = 0;
        memo[1] = 0;
        return dfs(cost, size, memo);
    }

    private int dfs(int[] cost, int index, Integer[] memo) {
        if (index > cost.length) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        int tmp = Math.min(dfs(cost, index - 1, memo) + cost[index - 1],
                dfs(cost, index - 2, memo) + cost[index - 2]);
        memo[index] = tmp;
        return tmp;
    }

    // dp.
    public int minCostClimbingStairs_dp(int[] cost) {
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
