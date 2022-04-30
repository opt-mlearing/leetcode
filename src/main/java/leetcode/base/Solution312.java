package leetcode.base;

import java.util.Arrays;

/**
 * 312. 戳气球
 * https://leetcode-cn.com/problems/burst-balloons/submissions/
 */
public class Solution312 {

    private int[][] preValues;

    // 自顶向下，递归.
    public int maxCoins(int[] nums) {
        int size = nums.length + 2;
        int[] values = new int[size];
        values[0] = 1;
        values[size - 1] = 1;
        for (int i = 0; i < size - 2; ++i) {
            values[i + 1] = nums[i];
        }
        preValues = new int[size][size];
        for (int i = 0; i < size; ++i) {
            Arrays.fill(preValues[i], -1);
        }
        return dfs(values, 0, size - 1);
    }

    private int dfs(int[] nums, int start, int end) {
        if (preValues[start][end] != -1) {
            return preValues[start][end];
        }
        if (start + 1 >= end) {
            return 0;
        }
        for (int i = start + 1; i < end; ++i) {
            int cost = nums[start] * nums[i] * nums[end];
            preValues[start][end] = Math.max(preValues[start][end], dfs(nums, start, i) + dfs(nums, i, end) + cost);
        }
        return preValues[start][end];
    }

    // 自底向上, dp.
    public int maxCoins_dp(int[] nums) {
        int size = nums.length + 2;
        int[] values = new int[size];
        values[0] = 1;
        values[size - 1] = 1;
        for (int i = 0; i < size - 2; ++i) {
            values[i + 1] = nums[i];
        }
        int[][] dp = new int[size][size];
        for (int i = size - 2; i >= 0; --i) {
            for (int j = i + 2; j < size; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }
            }
        }
        return dp[0][size - 1];
    }

}
