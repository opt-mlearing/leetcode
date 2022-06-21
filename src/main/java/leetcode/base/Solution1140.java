package leetcode.base;

/**
 * 1140. 石子游戏 II
 * https://leetcode.cn/problems/stone-game-ii/
 *
 * @author: caogl
 * @date: 2022/6/21, 21:43
 **/
public class Solution1140 {

    // 递归+记忆化搜索. 3ms/40.9mb.
    public int stoneGameII_recursion(int[] piles) {
        int size = piles.length;
        int[] postSum = new int[size + 1];
        for (int i = size - 1; i >= 0; --i) {
            postSum[i] = postSum[i + 1] + piles[i];
        }
        Integer[][] memo = new Integer[size][2 * size];
        return dfs(piles, 0, 1, postSum, memo);
    }

    private int dfs(int[] piles, int start, int m, int[] postSum, Integer[][] memo) {
        if (start >= piles.length) {
            return 0;
        }
        if (start + 2 * m >= piles.length) {
            return postSum[start];
        }
        if (memo[start][m] != null) {
            return memo[start][m];
        }
        // value是对手得分，需要限制对手等分最少.
        int value = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; ++x) {
            int nextm = Math.max(x, m);
            value = Math.min(value, dfs(piles, start + x, nextm, postSum, memo));
        }
        value = postSum[start] - value;
        memo[start][m] = value;
        return value;
    }

    // 动归，其中dp[i][m]表示在piles[i: size][m] 最多取m个的时候最大.
    public int stoneGameII_dp_1(int[] piles) {
        int size = piles.length;
        int[][] dp = new int[size][size + 1];
        int sum = 0;
        for (int i = size - 1; i >= 0; --i) {
            sum += piles[i];
            // i== 0 时 m= 1;
            for (int m = 1; m <= i || m == 1; ++m) {
                if (i + 2 * m >= size) {
                    dp[i][m] = sum;
                    continue;
                }
                for (int x = 1; x <= 2 * m; ++x) {
                    dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(x, m)]);
                }
            }
        }
        return dp[0][1];
    }

    // 动归，其中dp[i][m]表示在piles[i: size][m] 最多取m个的时候最大.
    public int stoneGameII(int[] piles) {
        int size = piles.length;
        int[][] dp = new int[size][size + 1];
        int sum = 0;
        for (int i = size - 1; i >= 0; --i) {
            sum += piles[i];
            // i== 0 时 m= 1;
            for (int m = 1; m <= size; ++m) {
                if (i + 2 * m >= size) {
                    dp[i][m] = sum;
                    continue;
                }
                for (int x = 1; x <= 2 * m; ++x) {
                    dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(x, m)]);
                }
            }
        }
        return dp[0][1];
    }

}
