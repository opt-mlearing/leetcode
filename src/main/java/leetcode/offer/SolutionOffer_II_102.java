package leetcode.offer;

/**
 * 剑指 Offer II 102. 加减的目标值
 * https://leetcode.cn/problems/YaVDxD/
 */
public class SolutionOffer_II_102 {

    // 正数和x，负数和 sum- x，
    public int findTargetSumWays_1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int bucket = target + sum;
        if ((bucket % 2) != 0) {
            return 0;
        }
        bucket = bucket / 2;
        int[] dp = new int[bucket + 1];
        dp[0] = 1;
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            for (int j = bucket; j >= nums[i]; --j) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bucket];
    }

    // 二维dp.
    public int findTargetSumWays_2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int size = nums.length;
        int bucket = (sum + target) / 2;
        int[][] dp = new int[size + 1][bucket + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= size; ++i) {
            for (int j = 0; j <= bucket; ++j) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[size][bucket];
    }

}
