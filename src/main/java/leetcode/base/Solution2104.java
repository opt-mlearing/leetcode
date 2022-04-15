package leetcode.base;

/**
 * 子数组范围和
 * https://leetcode-cn.com/problems/sum-of-subarray-ranges/
 */
public class Solution2104 {

    public long subArrayRanges(int[] nums) {
        long sumVal = 0;
        for (int i = 0; i < nums.length; ++i) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;
            // 依次遍历产生全部的组合.
            for (int j = i; j < nums.length; ++j) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                sumVal += maxVal - minVal;
            }
        }
        return sumVal;
    }

}
