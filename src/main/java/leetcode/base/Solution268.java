package leetcode.base;

import java.util.Arrays;

/**
 * 268. 丢失的数字
 * https://leetcode.cn/problems/missing-number/
 *
 * @author: caogl
 * @date: 2022/6/24, 1:48
 **/
public class Solution268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

}
