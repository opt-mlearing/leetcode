package leetcode.base;

/**
 * 第N个泰波那契数
 *
 * @link https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
public class Solution1137 {

    public int tribonacci(int n) {
        int[] dp = new int[n + 1 > 3 ? n + 1 : 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

}
