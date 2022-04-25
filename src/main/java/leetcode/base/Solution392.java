package leetcode.base;

/**
 * 392. 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class Solution392 {

    // 性能指标：时间/内存-> 5ms/41.MB
    public boolean isSubsequence_1(String s, String t) {
        int m = s.length();
        int n = t.length();
        // dp[i][j] ：长度为i，末尾项为s[i-1]的子字符串，与长度为j，末尾项为t[j-1]的子字符串，二者的相同子序列长度.
        int[][] dp = new int[n + 1][m + 1];
        // dp[i][j]表示s以i-1个字符结尾和t以j-1个字符结尾，二者相同子串长度.
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            // 这部分在这里没什么意义，外层循环是s字符串. if(dp[i][j]== m){return true};
        }
        return dp[n][m] == m;
    }

    // isSubsequence_1 优化.
    // 性能优化：时间/内存 -> 3ms/ 39.4MB
    public boolean isSubsequence_2(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = m; j >= 1; --j) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + 1;
                }
            }
        }
        return dp[m] == m;
    }

    // 双指针性能最佳
    // 性能指标：时间/内存 -> 1ms/39.1MB
    public boolean isSubsequence_double_pointer(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

}
