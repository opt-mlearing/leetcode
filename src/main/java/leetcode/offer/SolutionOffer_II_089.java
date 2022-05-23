package leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer II 089. 房屋偷盗
 * https://leetcode.cn/problems/Gu0c2T/
 */
public class SolutionOffer_II_089 {

    // dp动态规划.
    public int rob_dp(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= size; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[size];
    }

    private int[] memo;

    // 递归+ 记忆化搜索.
    public int rob(int[] nums) {
        int size = nums.length;
        memo = new int[size];
        Arrays.fill(memo, -1);
        return doRob(nums, 0, size);
    }

    private int doRob(int[] nums, int start, int size) {
        if (start >= size) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int tmp = Math.max(doRob(nums, start + 1, size), nums[start] + doRob(nums, start + 2, size));
        memo[start] = tmp;
        return memo[start];
    }

}
