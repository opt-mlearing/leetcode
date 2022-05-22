package leetcode.base;

import java.util.Arrays;

/**
 * 1406. 石子游戏 III
 * https://leetcode.cn/problems/stone-game-iii/
 */
public class Solution1406 {

    public String stoneGameIII(int[] stoneValue) {
        int size = stoneValue.length;
        int[] dp = new int[size + 1];
        // 这里一定赋值成最小.
        Arrays.fill(dp, Integer.MIN_VALUE);
        // 强调.
        dp[size] = 0;
        int[] preSum = new int[size + 1];
        for (int i = 0; i < size; ++i) {
            preSum[i + 1] = preSum[i] + stoneValue[i];
        }
        for (int i = size - 1; i >= 0; --i) {
            // 最多三个. 选1、2或3堆.
            for (int j = i + 1; j <= i + 3 && j <= size; ++j) {
                dp[i] = Math.max(dp[i], preSum[j] - preSum[i] - dp[j]);
            }
        }
        if (dp[0] == 0) {
            return "Tie";
        } else {
            return dp[0] > 0 ? "Alice" : "Bob";
        }
    }

}
