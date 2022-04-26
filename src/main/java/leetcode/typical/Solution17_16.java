package leetcode.typical;

/**
 * 面试题 17.16. 按摩师
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 */
public class Solution17_16 {

    public int massage(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums.length == 0 ? 0 : nums[0];
        }
        int size = nums.length;
        int[] dp = new int[size > 2 ? size : 2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[size - 1];
    }

}
