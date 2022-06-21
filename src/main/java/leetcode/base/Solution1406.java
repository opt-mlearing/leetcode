package leetcode.base;

import java.util.Arrays;

/**
 * 1406. 石子游戏 III
 * https://leetcode.cn/problems/stone-game-iii/
 *
 * @author: caogl
 * @date: 2022/6/21, 21:46
 **/
public class Solution1406 {

    // 递归+ 记忆化搜索.
    public String stoneGameIII(int[] stoneValue) {
        int size = stoneValue.length;
        Integer[] memo = new Integer[size];
        int[] preSum = new int[size];
        for (int i = 0; i < size; ++i) {
            if (i == 0) {
                preSum[0] = stoneValue[0];
                continue;
            }
            preSum[i] = preSum[i - 1] + stoneValue[i];
        }
        int value = stoneGameDfs(stoneValue, 0, memo, preSum);
        if (value > 0) {
            return "Alice";
        } else if (value < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int stoneGameDfs(int[] stoneValue, int index, Integer[] memo, int[] preSum) {
        if (index >= stoneValue.length) {
            return 0;
        }
        if (null != memo[index]) {
            return memo[index];
        }
        int value = Integer.MIN_VALUE;
        for (int i = index; i < stoneValue.length && i < index + 3; ++i) {
            int tmp = 0;
            if (index > 0) {
                tmp = preSum[i] - preSum[index - 1] - stoneGameDfs(stoneValue, i + 1, memo, preSum);
            } else {
                tmp = preSum[i] - stoneGameDfs(stoneValue, i + 1, memo, preSum);
            }
            value = Math.max(value, tmp);
        }
        memo[index] = value;
        return value;
    }

    // 递归+ 记忆搜索.
    public String stoneGameIII_recursion(int[] stoneValue) {
        int size = stoneValue.length;
        Integer[] memo = new Integer[size];
        int res = dfs(stoneValue, 0, memo);
        if (res > 0) {
            return "Alice";
        } else if (res < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int dfs(int[] stoneValue, int index, Integer[] memo) {
        if (index >= stoneValue.length) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        int value = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = index; i < index + 3 && i < stoneValue.length; ++i) {
            sum += stoneValue[i];
            value = Math.max(value, sum - dfs(stoneValue, i + 1, memo));
        }
        memo[index] = value;
        return value;
    }

    // dp 动态规划.
    public String stoneGameIII_dp(int[] stoneValue) {
        int size = stoneValue.length;
        int[] preSum = new int[size + 1];
        for (int i = 0; i < size; ++i) {
            preSum[i + 1] = preSum[i] + stoneValue[i];
        }
        int[] dp = new int[size + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        // 注意，这里一定需要置0.
        dp[size] = 0;
        for (int i = size; i >= 0; --i) {
            for (int j = i + 1; j <= size && j <= i + 3; ++j) {
                dp[i] = Math.max(dp[i], preSum[j] - preSum[i] - dp[j]);
            }
        }
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

}
