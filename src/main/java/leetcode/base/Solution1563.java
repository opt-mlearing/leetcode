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

}
