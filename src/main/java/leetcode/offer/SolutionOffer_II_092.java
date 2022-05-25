package leetcode.offer;

/**
 * 剑指 Offer II 092. 翻转字符
 * https://leetcode.cn/problems/cyJERH/
 */
public class SolutionOffer_II_092 {

    public int minFlipsMonoIncr(String s) {
        int size = s.length();
        char[] item = s.toCharArray();
        int[][] dp = new int[size][2];
        dp[0][0] = item[0] == '0' ? 0 : 1;
        dp[0][1] = item[0] == '1' ? 0 : 1;
        for (int i = 1; i < size; ++i) {
            if (item[i] == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[size - 1][0], dp[size - 1][1]);
    }

}
