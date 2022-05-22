package leetcode.base;

/**
 * 1563. 石子游戏 V
 * https://leetcode.cn/problems/stone-game-v/
 */
public class Solution1563 {

    private int[] preSum;
    private int[][] dp;

    // dfs.
    public int stoneGameV_dfs(int[] stoneValue) {
        int size = stoneValue.length;
        dp = new int[size][size];
        return dfs(stoneValue, 0, size - 1);
    }

    private int dfs(int[] stoneValue, int left, int right) {
        if (left == right) {
            return 0;
        }
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        int sum = 0;
        for (int i = left; i <= right; ++i) {
            sum += stoneValue[i];
        }
        int leftSum = 0;
        int res = 0;
        for (int i = left; i < right; ++i) {
            leftSum += stoneValue[i];
            int rightSum = sum - leftSum;
            if (leftSum < rightSum) {
                res = Math.max(res, leftSum + dfs(stoneValue, left, i));
            } else if (leftSum > rightSum) {
                res = Math.max(res, rightSum + dfs(stoneValue, i + 1, right));
            } else {
                res = Math.max(res, leftSum + Math.max(dfs(stoneValue, left, i), dfs(stoneValue, i + 1, right)));
            }
        }
        dp[left][right] = res;
        return res;
    }

    // dp动态规划.
    public int stoneGameV_dp(int[] stoneValue) {
        int size = stoneValue.length;
        int[][] dp = new int[size][size];
        int[] preSum = new int[size + 1];
        for (int i = 0; i < size; ++i) {
            preSum[i + 1] = preSum[i] + stoneValue[i];
        }
        for (int len = 1; len <= size; ++len) {
            for (int i = size - 1; i >= 0; --i) {
                int j = i + len - 1;
                if (j >= size) {
                    continue;
                }
                // 枚举切点.
                for (int k = i; k < j; ++k) {
                    int left = preSum[k + 1] - preSum[i];
                    int right = preSum[j + 1] - preSum[k + 1];
                    if (left < right) {
                        dp[i][j] = Math.max(dp[i][j], left + dp[i][k]);
                    } else if (left > right) {
                        dp[i][j] = Math.max(dp[i][j], right + dp[k + 1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], Math.max(left + dp[i][k], right + dp[k + 1][j]));
                    }
                }
            }
        }
        return dp[0][size - 1];
    }

}
