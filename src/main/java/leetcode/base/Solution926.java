package leetcode.base;

/**
 * 926. 将字符串翻转到单调递增
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 */
public class Solution926 {

    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        int[][] dp = new int[size][2];
        dp[0][0] = chars[0] == '0' ? 0 : 1;
        dp[0][1] = chars[0] == '1' ? 0 : 1;
        for (int i = 1; i < size; ++i) {
            if (chars[i] == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]) + 1;
            } else if (chars[i] == '1') {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[size - 1][0], dp[size - 1][1]);
    }

}
