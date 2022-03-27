package leetcode;

import java.util.Arrays;

/**
 * 组合总和 Ⅳ
 * https://leetcode-cn.com/problems/combination-sum-iv/
 */
public class Solution377 {

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
