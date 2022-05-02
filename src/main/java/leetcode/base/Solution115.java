package leetcode.base;

/**
 * 115. 不同的子序列
 * https://leetcode-cn.com/problems/distinct-subsequences/
 */
public class Solution115 {

    // 其中, dp}[i][j]表示在s[i:]的子序列中t[j:]出现的个数
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return 0;
        }
        // t[j:] 当j== n 时候，t为空串;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

}
