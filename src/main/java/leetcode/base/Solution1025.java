package leetcode.base;

/**
 * 1025. 除数博弈
 * https://leetcode-cn.com/problems/divisor-game/
 *
 * @author: caogl
 * @date: 2022/6/21, 21:39
 **/
public class Solution1025 {

    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[Math.max(n + 1, 3)];
        // dp[0]
        dp[1] = false;
        dp[2] = true;
        for (int x = 3; x <= n; ++x) {
            for (int i = 1; i <= x / 2; ++i) {
                if ((x % i == 0) && !dp[x - i]) {
                    dp[x] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public boolean divisorGame_recursion(int n) {
        Boolean[] memo = new Boolean[Math.max(n + 1, 3)];
        memo[1] = false;
        memo[2] = true;
        return dfs1(memo, n);
    }

    private boolean dfs1(Boolean[] memo, int n) {
        if (null != memo[n]) {
            return memo[n];
        }
        boolean flag = false;
        // 0< x< n && n% x== 0;
        for (int x = 1; x <= n / 2; ++x) {
            if (n % x == 0 && !dfs1(memo, n - x)) {
                flag = true;
                break;
            }
        }
        memo[n] = flag;
        return flag;
    }

    private boolean dfs(Boolean[] memo, int n) {
        if (memo[n] != null) {
            return memo[n];
        }
        boolean flag = false;
        for (int i = 1; i <= n / 2; ++i) {
            if (n % i == 0) {
                flag |= !dfs(memo, n - i);
            }
        }
        memo[n] = flag;
        return flag;
    }

    public boolean divisorGame_dp1(int n) {
        if (n == 1) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        // dp[0] 没啥意义可或略
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j <= i / 2; ++j) {
                if ((i % j == 0) && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

}
