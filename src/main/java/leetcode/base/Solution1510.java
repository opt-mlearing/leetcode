package leetcode.base;

/**
 * 1510. 石子游戏 IV
 * https://leetcode.cn/problems/stone-game-iv/
 */
public class Solution1510 {

    public boolean winnerSquareGame(int n) {
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

}
