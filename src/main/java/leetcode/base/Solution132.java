package leetcode.base;

import java.util.Arrays;

/**
 * 132. 分割回文串 II
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 */
public class Solution132 {

    public int minCut(String s) {
        int size = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[size][size];
        for (int i = size - 1; i >= 0; --i) {
            for (int j = i; j < size; ++j) {
                if ((chars[i] == chars[j]) && (i + 1 >= j || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        int[] res = new int[size];
        Arrays.fill(res, size - 1);
        for (int j = 0; j < size; ++j) {
            if (dp[0][j]) {
                res[j] = 0;
            }
            for (int i = 0; i < j; ++i) {
                if (dp[i + 1][j]) {
                    res[j] = Math.min(res[j], res[i] + 1);
                }
            }
        }
        return res[size - 1];
    }

}
