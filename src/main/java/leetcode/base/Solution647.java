package leetcode.base;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class Solution647 {

    public int countSubstrings(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        int res = 0;
        for (int i = size - 1; i >= 0; --i) {
            for (int j = i; j < size; ++j) {
                if (s.charAt(i) == s.charAt(j) && ((i + 1 >= j) || dp[i + 1][j - 1])) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }

}
