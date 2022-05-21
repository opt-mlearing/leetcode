package leetcode.base;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 * https://leetcode.cn/problems/array-partition-i/
 */
public class Solution561 {

    public int arrayPairSum(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < size; i += 2) {
            res += nums[i];
        }
        return res;
    }

}
