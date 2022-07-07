package leetcode.base;

/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * @author: caogl
 * @date: 2022/7/8, 3:15
 **/
public class Solution5 {

    public String longestPalindrome(String s) {
        int size = s.length();
        if (size <= 1) {
            return s;
        }
        int begin = 0;
        int maxLength = 1;
        boolean[][] dp = new boolean[size][size];
        for (int i = 0; i < size; ++i) {
            dp[i][i] = true;
        }
        for (int i = size - 2; i >= 0; --i) {
            for (int j = i + 1; j < size; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 >= maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    // 165ms/44.8mb
    public String longestPalindrome_1(String s) {
        int size = s.length();
        if (size <= 1) {
            return s;
        }
        int begin = 0;
        int maxLength = 1;
        boolean[][] dp = new boolean[size][size];
        for (int i = 0; i < size; ++i) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int len = 1; len < size; ++len) {
            for (int left = 0; left < size - len; ++left) {
                int right = left + len;
                if (charArray[left] != charArray[right]) {
                    dp[left][right] = false;
                } else {
                    if (right - left > 2) {
                        dp[left][right] = dp[left + 1][right - 1];
                    } else {
                        // 三个字符的也成立.
                        dp[left][right] = true;
                    }
                }
                if (dp[left][right] && right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    begin = left;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

}
