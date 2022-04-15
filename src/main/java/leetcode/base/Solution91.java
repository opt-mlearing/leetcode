package leetcode.base;

/**
 * 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class Solution91 {

    public int numDecodings(String s) {
        // dp[i]= dp[i- 1]+ dp[i- 2], 注意边界，数字是否会越界.
        int size = s.length();
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 1; i <= size; ++i) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (((s.charAt(i - 2) - '0') * 10) + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[size];
    }

}
