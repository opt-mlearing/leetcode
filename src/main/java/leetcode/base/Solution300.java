package leetcode.base;

import java.util.Arrays;

/**
 * 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class Solution300 {

    // 注意，题目中明确的是序不是子串，子串是连续的.
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // nums[j]< nums[i] --> dp[i]= max(dp[i], dp[j]+ 1)
        int[] dp = new int[nums.length];
        // 这个很重要，每个元素递增至少为1，就是nums[i]中那个数.
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

}
