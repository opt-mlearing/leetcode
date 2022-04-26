package leetcode.typical;

/**
 * 面试题 16.17. 连续数列
 * https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 */
public class Solution16_17 {

    // 连续 && 和
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int res = nums[0];
        int curr = nums[0];
        for (int i = 1; i < size; ++i) {
            curr = Math.max(nums[i], curr + nums[i]);
            res = Math.max(curr, res);
        }
        return res;
    }

}
