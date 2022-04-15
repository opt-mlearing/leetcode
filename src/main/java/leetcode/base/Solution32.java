package leetcode.base;

/**
 * 32. 最长有效括号
 * https://yangleetcode-cn.com/problems/longest-valid-parentheses/
 */
public class Solution32 {

    // dp[i]= 2+ dp[i- 1]+ dp[i- dp[i- 1]- 2];
    public int longestValidParentheses(String s) {
        int size = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[size];
        int res = 0;
        for (int i = 1; i < size; ++i) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && chars[i - dp[i - 1] - 1] == '(') {
                    dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 1 > 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
