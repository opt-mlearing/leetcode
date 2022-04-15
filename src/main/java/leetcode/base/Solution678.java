package leetcode.base;

/**
 * 678. 有效的括号字符串
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 */
public class Solution678 {

    // dp[i][j] 表示从下标i到下标j子串 是否为有效字符串. 0<=i<=j< n .
    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        boolean[][] dp = new boolean[size][size];
        // 子串长度为1的情况.
        for (int i = 0; i < size; ++i) {
            if (chars[i] == '*') {
                dp[i][i] = true;
            }
        }
        // 子串长度为2的情况
        for (int i = 1; i < size; ++i) {
            char first = chars[i - 1];
            char second = chars[i];
            if ((first == '*' || first == '(') && (second == ')' || second == '*')) {
                dp[i - 1][i] = true;
            }
        }
        // 子串长度大于2的情况
        for (int i = size - 3; i >= 0; --i) {
            int itemI = chars[i];
            // i<= j
            for (int j = i + 2; j < size; ++j) {
                int itemJ = chars[j];
                // i, i+ 1, ..., j-1, j
                if ((itemI == '*' || itemI == '(') && (itemJ == '*' || itemJ == ')')) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                // i, ..., k, ...., j
                // 其中只要dp[i][j]== false 则k一直循环下去，
                // 直到循环结束或者找到有效的两个连续字串拼接方案.
                for (int k = i; k < j && dp[i][j] == false; ++k) {
                    dp[i][j] = dp[i][k] && dp[k + 1][j];
                }
            }
        }
        return dp[0][size - 1];
    }

}
