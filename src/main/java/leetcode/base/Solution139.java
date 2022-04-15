package leetcode.base;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 */
public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<String>(wordDict);
        for (int i = 1; i <= s.length(); ++i) {
            // j表示切点.
            for (int j = 0; j < i; ++j) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

}
