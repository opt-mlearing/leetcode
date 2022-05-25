package leetcode.offer;

/**
 * 剑指 Offer II 090. 环形房屋偷盗
 * https://leetcode.cn/problems/PzWKhm/
 */
public class SolutionOffer_II_090 {

    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        } else if (size == 1) {
            return nums[0];
        } else if (size == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(doRob(nums, 0, size - 2), doRob(nums, 1, size - 1));
    }

    private int doRob(int[] nums, int left, int right) {
        int[] dp = new int[right + 1];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[right];
    }

}
