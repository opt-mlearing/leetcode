package leetcode.base;

/**
 * 494. 目标和
 * https://leetcode-cn.com/problems/target-sum/
 */
public class Solution494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int bagSize = (sum + target) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        // dp[i]= dp[i]+ dp[i- nums[j]];
        // 01背包.
        // 排列数.
        for (int i = 0; i < nums.length; ++i) {
            for (int j = bagSize; j >= nums[i]; --j) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }

}
