package leetcode.base;

/**
 * 44. 通配符匹配
 * https://leetcode-cn.com/problems/wildcard-matching/
 */
public class Solution44 {

    // 方法2空间优化.
    public boolean isMatch_3(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // 必须从头开始连续.
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            boolean[] tmp = new boolean[n + 1];
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    tmp[j] = tmp[j - 1] | dp[j];
                } else {
                    if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        tmp[j] = dp[j - 1];
                    }
                }
            }
            dp = tmp;
        }
        return dp[n];
    }

    public boolean isMatch_2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // s && p 都是空串.
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    // 理睬j=='*' | 不理睬j=='*'.
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                } else {
                    if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch_1(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j] 表示s的前i个字符是否与p的前j个字符匹配.
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                // 从后往前看.
                // 这里已经把j==0的情况全部处理.
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] |= dp[i][j - 1];
                    if (i > 0) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    if (i > 0 && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1))) {
                        dp[i][j] |= dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

}
