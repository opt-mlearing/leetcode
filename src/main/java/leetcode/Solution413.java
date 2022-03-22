package leetcode;

/**
 * 等差数列划分
 * https://leetcode-cn.com/problems/arithmetic-slices/
 */
public class Solution413 {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int res = 0;
        int len = 2;
        int preDiff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; ++i) {
            int diff = nums[i] - nums[i - 1];
            if (preDiff == diff) {
                ++len;
            } else {
                res += (len - 2) * (len - 1) / 2;
                preDiff = diff;
                len = 2;
            }
        }
        res += (len - 2) * (len - 1) / 2;
        return res;
    }

    public int numberOfArithmeticSlices_by_dp(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }
        return res;
    }

}
