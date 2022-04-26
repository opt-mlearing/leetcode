package leetcode.lcs;

/**
 * LCS 01. 下载插件
 * https://leetcode-cn.com/problems/Ju9Xwi/
 */
public class SolutionLCS_01 {

    public int leastMinutes(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[(i + 1) / 2] + 1;
        }
        return dp[n];
    }

}
