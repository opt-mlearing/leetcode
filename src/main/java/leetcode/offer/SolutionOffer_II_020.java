package leetcode.offer;

/**
 * 剑指 Offer II 020. 回文子字符串的个数
 * https://leetcode.cn/problems/a7VOhD/
 */
public class SolutionOffer_II_020 {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        boolean[][] dp = new boolean[size][size];
        int res = 0;
        for (int i = size - 1; i >= 0; --i) {
            for (int j = i; j < size; ++j) {
                if (chars[i] == chars[j]) {
                    if (i == j) {
                        dp[i][j] = true;
                        res++;
                    } else if (j - i == 1) {
                        dp[i][j] = true;
                        res++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }

}
