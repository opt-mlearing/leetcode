package leetcode.base;

/**
 * 1137. 第 N 个泰波那契数
 * https://leetcode.cn/problems/n-th-tribonacci-number/
 *
 * @author: caogl
 * @date: 2022/6/20, 23:18
 **/
public class Solution1137 {

    public int tribonacci_dp(int n) {
        int[] dp = new int[n + 1 > 3 ? n + 1 : 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    private Integer[] memo;

    public int tribonacci(int n) {
        memo = new Integer[n + 1 >= 3 ? n + 1 : 3];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        return dfs(n);
    }

    private int dfs(int n) {
        if (memo[n] != null) {
            return memo[n];
        }
        int value = dfs(n - 1) + dfs(n - 2) + dfs(n - 3);
        memo[n] = value;
        return value;
    }

}
