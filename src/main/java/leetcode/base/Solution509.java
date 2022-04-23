package leetcode.base;

/**
 * 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class Solution509 {

    // 递归，11ms/37.9MB
    public int fib_recursion(int n) {
        if (n <= 1) {
            return n;
        }
        return fib_recursion(n - 1) + fib_recursion(n - 2);
    }

    // 动态规划，0ms/ 38.3MB
    public int fib_dp1(int n) {
        int[] dp = new int[Math.max(n, 1) + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 动态规划，0ms/ 37.7MB
    public int fib_dp2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }

}
