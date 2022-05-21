package leetcode.base;

/**
 * 712. 两个字符串的最小ASCII删除和
 * https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/
 */
public class Solution712 {

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = m - 1; i >= 0; --i) {
            dp[i][n] += dp[i + 1][n] + s1.charAt(i);
        }
        for (int i = n - 1; i >= 0; --i) {
            dp[m][i] += dp[m][i + 1] + s2.charAt(i);
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.charAt(i), dp[i][j + 1] + s2.charAt(j));
                }
            }
        }
        return dp[0][0];
    }

}
