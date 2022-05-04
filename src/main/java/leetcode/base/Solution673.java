package leetcode.base;

/**
 * 673. 最长递增子序列的个数
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 */
public class Solution673 {

    public int findNumberOfLIS(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size][2];
        for (int i = 0; i < size; ++i) {
            // 最长子序列长度.
            dp[i][0] = 1;
            // 最长子序列个数.
            dp[i][1] = 1;
        }
        int maxLen = 1;
        int res = 1;
        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[j][0] + 1 == dp[i][0]) {
                        // 注意这里，相等的情况.
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            if (dp[i][0] > maxLen) {
                maxLen = dp[i][0];
                res = dp[i][1];
            } else if (dp[i][0] == maxLen) {
                // 注意这里，相等的情况.
                res += dp[i][1];
            }
        }
        return res;
    }

}
