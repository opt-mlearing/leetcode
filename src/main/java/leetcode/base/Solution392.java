package leetcode.base;

/**
 * 392. 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class Solution392 {

    // dp[i][j] ：长度为i，末尾项为s[i-1]的子字符串，与长度为j，末尾项为t[j-1]的子字符串，二者的相同子序列长度.
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m] == m;
    }

}
