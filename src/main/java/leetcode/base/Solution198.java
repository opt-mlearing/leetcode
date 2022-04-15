package leetcode.base;

/**
 * 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Solution198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 当nums中仅且只有一个元素的时候，需要特殊处理下.
        if (nums.length > 1) {
            dp[1] = Math.max(nums[1], nums[0]);
        }
        // 动态转移方程：dp[i]= Math.max(dp[i- 1], dp[i- 2]+ nums[i]);
        for (int i = 2; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

}
