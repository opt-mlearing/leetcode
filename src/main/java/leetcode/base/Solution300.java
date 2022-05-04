package leetcode.base;

import java.util.Arrays;

/**
 * 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class Solution300 {

    // 加入二分优化.
    public int lengthOfLIS_1(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        int len = 1;
        int[] d = new int[size + 1];
        d[len] = nums[0];
        for (int i = 1; i < size; ++i) {
            if (nums[i] > d[len]) {
                len++;
                d[len] = nums[i];
            } else {
                int l = 1;
                int r = len;
                int pos = 0;
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

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
