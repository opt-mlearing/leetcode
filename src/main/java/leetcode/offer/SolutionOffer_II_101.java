package leetcode.offer;

/**
 * 剑指 Offer II 101. 分割等和子集
 * https://leetcode.cn/problems/NUPfPr/
 */
public class SolutionOffer_II_101 {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = target; j >= nums[i]; --j) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

}
