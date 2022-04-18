package leetcode.base;

/**
 * 486. 预测赢家
 * https://leetcode-cn.com/problems/predict-the-winner/
 */
public class Solution486 {

    // 二维dp
    public boolean PredictTheWinner_2(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; ++i) {
            dp[i][i] = nums[i];
        }
        // i<= j
        for (int i = size - 2; i >= 0; --i) {
            for (int j = i + 1; j < size; ++j) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][size - 1] >= 0;
    }

    // 一维dp
    public boolean PredictTheWinner(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        for (int i = 0; i < size; ++i) {
            dp[i] = nums[i];
        }
        for (int i = size - 2; i >= 0; --i) {
            for (int j = i + 1; j < size; ++j) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[size - 1] >= 0;
    }

}
