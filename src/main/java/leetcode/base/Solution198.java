package leetcode.base;

/**
 * 198. 打家劫舍
 * https://leetcode.cn/problems/house-robber/
 *
 * @author: caogl
 * @date: 2022/6/22, 0:44
 **/
public class Solution198 {

    public int rob_dp(int[] nums) {
        int[] dp = new int[nums.length];
        // dp[i]= max(dp[i- 1], dp[i- 2]+ nums[i]);
        dp[0] = nums[0];
        if (nums.length >= 2) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    //  递归+ 记忆化搜索.
    public int rob(int[] nums) {
        int size = nums.length;
        Integer[] memo = new Integer[size];
        return dfs(nums, memo, size - 1);
    }

    private int dfs(int[] nums, Integer[] memo, int index) {
        if (index < 0) {
            return 0;
        }
        if (null != memo[index]) {
            return memo[index];
        }
        int res = Math.max(dfs(nums, memo, index - 1), dfs(nums, memo, index - 2) + nums[index]);
        memo[index] = res;
        return res;
    }

}
