package leetcode.base;

import java.util.Arrays;

/**
 * 674. 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class Solution674 {

    public int findLengthOfLCIS(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < size; ++i) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
