package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 098. 路径的数目
 * https://leetcode.cn/problems/2AoeFn/
 */
public class SolutionOffer_II_098 {

    // dfs + 记忆化搜索.
    public int uniquePaths(int m, int n) {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return dfs(m, n, 0, 0, memo);
    }

    private int dfs(int m, int n, int left, int right, Map<Integer, Integer> memo) {
        if (left < 0 || left >= m || right < 0 || right >= n) {
            return 0;
        }
        int key = getKey(m, n, left, right);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (left == m - 1 && right == n - 1) {
            return 1;
        }
        int res = dfs(m, n, left + 1, right, memo) + dfs(m, n, left, right + 1, memo);
        memo.put(key, res);
        return res;
    }

    // 获取缓存Key.
    private int getKey(int m, int n, int left, int right) {
        if (m >= n) {
            return m * left + right;
        } else {
            return n * right + left;
        }
    }

    // 二维dp.
    public int uniquePaths_2(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; ++i) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 一维dp.
    public int uniquePaths_1(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
