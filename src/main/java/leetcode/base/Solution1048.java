package leetcode.base;

import java.util.Arrays;

/**
 * 1048. 最长字符串链
 * https://leetcode-cn.com/problems/longest-string-chain/
 */
public class Solution1048 {

    public int longestStrChain(String[] words) {
        int size = words.length;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        int res = 1;
        Arrays.sort(words, (word1, word2) -> Integer.compare(word1.length(), word2.length()));
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size; ++j) {
                if (isPrecess(words[i], words[j])) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    res = Math.max(res, dp[j]);
                }
            }
        }
        return res;
    }

    private boolean isPrecess(String pre, String post) {
        if (pre.length() + 1 != post.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < pre.length() && j < post.length()) {
            if (pre.charAt(i) == post.charAt(j)) {
                ++i;
            }
            ++j;
        }
        return i == pre.length();
    }

}
