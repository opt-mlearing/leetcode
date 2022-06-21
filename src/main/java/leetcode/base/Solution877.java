package leetcode.base;

/**
 * 877. 石子游戏
 * https://leetcode-cn.com/problems/stone-game/
 *
 * @author: caogl
 * @date: 2022/6/21, 21:41
 **/
public class Solution877 {

    // 递归+记忆化搜索.
    public boolean stoneGame(int[] piles) {
        int size = piles.length;
        Integer[][] memo = new Integer[size][size];
        for (int i = 0; i < size; ++i) {
            memo[i][i] = piles[i];
        }
        return dfs(memo, 0, size - 1, piles) >= 0;
    }

    private int dfs(Integer[][] memo, int left, int right, int[] piles) {
        if (left > right) {
            return 0;
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        int value = Math.max(piles[left] - dfs(memo, left + 1, right, piles),
                piles[right] - dfs(memo, left, right - 1, piles));
        memo[left][right] = value;
        return value;
    }

    // 一维dp,4ms/39mb.
    public boolean stoneGame_1(int[] piles) {
        int size = piles.length;
        int[] dp = new int[size];
        for (int i = 0; i < size; ++i) {
            dp[i] = piles[i];
        }
        for (int i = size - 1; i >= 0; --i) {
            for (int j = i + 1; j < size; ++j) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[size - 1] >= 0;
    }

    // 二维dp,7ms/42mb.
    public boolean stoneGame_21(int[] piles) {
        int size = piles.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; ++i) {
            dp[i][i] = piles[i];
        }
        for (int j = size - 1; j >= 0; --j) {
            for (int i = 0; i < j; ++i) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][size - 1] >= 0;
    }

    // 2维dp,6ms/42.5mb.
    public boolean stoneGame_22(int[] piles) {
        int size = piles.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; ++i) {
            dp[i][i] = piles[i];
        }
        for (int len = 1; len < size; ++len) {
            for (int i = 0; i < size - len; ++i) {
                int j = i + len;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][size - 1] >= 0;
    }

}
