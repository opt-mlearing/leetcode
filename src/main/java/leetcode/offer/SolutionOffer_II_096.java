package leetcode.offer;

/**
 * 剑指 Offer II 096. 字符串交织
 * https://leetcode.cn/problems/IY6buf/
 */
public class SolutionOffer_II_096 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 空串和空串相等.
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                int index3 = i + j - 1;
                if (i > 0) {
                    dp[i][j] |= dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(index3));
                }
                if (j > 0) {
                    dp[i][j] |= dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(index3));
                }
            }
        }
        return dp[m][n];
    }

}
