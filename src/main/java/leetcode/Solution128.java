package leetcode;

import java.util.Arrays;

/**
 * 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class Solution128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int size = nums.length;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        for (int i = 1; i < size; ++i) {
            if (nums[i] == nums[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
            } else if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
            }
        }
        int res = 1;
        for (int i = 1; i < size; ++i) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
