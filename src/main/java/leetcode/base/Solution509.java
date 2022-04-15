package leetcode.base;

public class Solution509 {

    // 斐波那契数列指的是这样一个数列：1，1，2，3，5，8，13，21，34，55，89...
    // 特性：这个数列从第3项开始，每一项都等于前两项之和。
    public int fib(int n) {
        int[] dp = new int[n + 1 > 2 ? n + 1 : 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
