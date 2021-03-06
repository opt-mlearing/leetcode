package leetcode.base;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author: caogl
 * @date: 2022/6/20, 23:20
 **/
public class Solution70 {

    private Integer[] memo;

    public int climbStairs_memo(int n) {
        memo = new Integer[n + 1 >= 3 ? n + 1 : 3];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        return dfs(n);
    }

    private int dfs(int n) {
        if (memo[n] != null) {
            return memo[n];
        }
        int count = dfs(n - 1) + dfs(n - 2);
        memo[n] = count;
        return count;
    }

    public int climbStairs_dp(int n) {
        // dp[i]= dp[i- 1]+ dp[i- 2]
        // dp[i] 表示到达第i阶的方案数为dp[i]个.
        int[] dp = new int[n + 1 >= 3 ? n + 1 : 3];
        // dp[0] 看起来并无意义，可以不进行初始化.
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
