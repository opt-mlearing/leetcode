package leetcode;

public class Solution01_05 {

    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n] <= 1;
    }

}
