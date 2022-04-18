package leetcode.base;

/**
 * 877. 石子游戏
 * https://leetcode-cn.com/problems/stone-game/
 */
public class Solution877 {

    // 一维度动态规划.
    public boolean stoneGame(int[] piles) {
        int size = piles.length;
        int[] dp = new int[size];
        for (int i = 0; i < size; ++i) {
            dp[i] = piles[i];
        }
        for (int i = size - 2; i >= 0; --i) {
            for (int j = i + 1; j < size; ++j) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[size - 1] > 0;
    }

    // 二维动态规划.
    public boolean stoneGame_2(int[] piles) {
        int size = piles.length;
        // dp[i][j]表示当剩下i到j时，当前玩家与前面玩家石子数相差最大.
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; ++i) {
            dp[i][i] = piles[i];
        }
        // 注意这里i<= j dp[i][j] 才有意义.
        for (int i = size - 2; i >= 0; --i) {
            for (int j = i + 1; j < size; ++j) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        // Alice先手, Bob后手，确定无平局.
        return dp[0][size - 1] > 0;
    }

}
