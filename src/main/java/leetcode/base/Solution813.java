package leetcode.base;

/**
 * 813. 最大平均值和的分组
 * https://leetcode.cn/problems/largest-sum-of-averages/
 *
 * @author caogaoli
 * @date 2022/6/22 20:42
 */
public class Solution813 {

    public double largestSumOfAverages(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        double[] dp = new double[len];
        for (int i = 0; i < len; ++i) {
            dp[i] = (double) (preSum[len] - preSum[i]) / (len - i);
        }
        for (int m = 1; m < k; ++m) {
            for (int i = 0; i < len; ++i) {
                for (int j = i + 1; j < len; ++j) {
                    dp[i] = Math.max(dp[i], dp[j] + (double) (preSum[j] - preSum[i]) / (j - i));
                }
            }
        }
        return dp[0];
    }

}
