package leetcode.base;

/**
 * 213. 打家劫舍 II
 * https://leetcode.cn/problems/house-robber-ii/
 *
 * @author: caogl
 * @date: 2022/6/22, 1:18
 **/
public class Solution213 {

    // dp
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        } else if (size == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(rob(nums, 0, size - 2), rob(nums, 1, size - 1));
        }
    }

    private int rob(int[] nums, int left, int right) {
        int[] dp = new int[right + 1];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[right];
    }

    // dp,压缩空间.
    public int rob_dp1(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        } else if (size == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(robDp(nums, 0, size - 2), robDp(nums, 1, size - 1));
        }
    }

    private int robDp(int[] nums, int left, int right) {
        int first = nums[left];
        int second = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; ++i) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }

    // 递归+ 记忆化搜索
    public int rob_recursion(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        } else if (size == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(dfs(nums, 0, size - 2, new Integer[size]),
                    dfs(nums, 1, size - 1, new Integer[size]));
        }
    }

    public int dfs(int[] nums, int left, int index, Integer[] memo) {
        if (index < left) {
            return 0;
        }
        if (null != memo[index]) {
            return memo[index];
        }
        int val = Math.max(dfs(nums, left, index - 1, memo),
                dfs(nums, left, index - 2, memo) + nums[index]);
        memo[index] = val;
        return val;
    }

}
