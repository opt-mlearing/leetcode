package leetcode.base;

/**
 * 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class Solution279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            // 1的平方还是1.
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
