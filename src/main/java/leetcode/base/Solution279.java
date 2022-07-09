package leetcode.base;

/**
 * 279. 完全平方数
 * https://leetcode.cn/problems/perfect-squares/
 *
 * @author: caogl
 * @date: 2022/7/10, 1:31
 **/
public class Solution279 {

    public int numSquares_1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                tmp = Math.min(tmp, dp[i - j * j]);
            }
            if (tmp != Integer.MAX_VALUE) {
                dp[i] = tmp + 1;
            }
        }
        return dp[n];
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                tmp = Math.min(tmp, dp[i - j * j] + 1);
            }
            dp[i] = tmp;
        }
        return dp[n];
    }

}
