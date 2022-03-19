package leetcode;

/**
 * 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class Solution213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            // 从0出发的，搜索到nums.length- 2的位置（包含）
            // 出1出发的，搜索到nums.length- 1的位置（包含）
            return Math.max(doRob(nums, 0, nums.length - 2), doRob(nums, 1, nums.length - 1));
        }
    }

    private int doRob(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; ++i) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }

}
