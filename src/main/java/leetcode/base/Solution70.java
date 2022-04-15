package leetcode.base;

import java.util.Arrays;

public class Solution70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1 < 3 ? 3 : n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
