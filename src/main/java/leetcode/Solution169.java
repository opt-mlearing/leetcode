package leetcode;

import java.util.Arrays;

/**
 * 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 */
public class Solution169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
