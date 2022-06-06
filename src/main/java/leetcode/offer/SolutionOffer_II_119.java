package leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer II 119. 最长连续序列
 * https://leetcode.cn/problems/WhsWhI/
 */
public class SolutionOffer_II_119 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 升序排列.
        Arrays.sort(nums);
        int size = nums.length;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        // 若nums不为空，那么最短的长度等于1.
        int res = 1;
        for (int i = 1; i < size; ++i) {
            if (nums[i] == nums[i - 1] + 1) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            } else if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
