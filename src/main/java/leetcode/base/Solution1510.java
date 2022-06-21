package leetcode.base;

/**
 * 1510. 石子游戏 IV
 * https://leetcode.cn/problems/stone-game-iv/
 *
 * @author: caogl
 * @date: 2022/6/21, 22:26
 **/
public class Solution1510 {

    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] |= !dp[i - j * j];
            }
        }
        return dp[n];
    }

    public boolean winnerSquareGame_dp(int n) {
        boolean[] dp = new boolean[n + 1];
        // 先手输.
        dp[0] = false;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public boolean winnerSquareGame_recursion(int n) {
        Boolean[] memo = new Boolean[n + 1];
        memo[0] = false;
        return dfs1(n, memo);
    }

    private boolean dfs1(int n, Boolean[] memo) {
        if (memo[n] != null) {
            return memo[n];
        }
        boolean flag = false;
        for (int i = (int) Math.sqrt(n); i >= 1; --i) {
            if (!dfs1(n - i * i, memo)) {
                flag = true;
                break;
            }
        }
        memo[n] = flag;
        return flag;
    }

    private boolean dfs(int n, Boolean[] memo) {
        if (memo[n] != null) {
            return memo[n];
        }
        boolean flag = false;
        for (int i = (int) Math.sqrt(n); i >= 1; --i) {
            flag |= !dfs(n - i * i, memo);
        }
        memo[n] = flag;
        return flag;
    }

}
