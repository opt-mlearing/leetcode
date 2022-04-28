package leetcode.offer;

/**
 * 剑指 Offer II 104. 排列的数目
 * https://leetcode-cn.com/problems/D0F0SV/
 */
public class SolutionOffer_II_104 {

    public int combinationSum4(int[] nums, int target) {
        int size = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < size; ++j) {
                if (i - nums[j] >= 0) {
                    dp[i] = dp[i] + dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
