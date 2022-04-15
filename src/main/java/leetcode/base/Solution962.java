package leetcode.base;

import java.util.Arrays;

/**
 * 最大宽度坡
 * https://leetcode-cn.com/problems/maximum-width-ramp/
 */
public class Solution962 {

    public int maxWidthRamp(int[] nums) {
        int size = nums.length;
        Integer[] tmp = new Integer[size];
        for (int i = 0; i < size; ++i) {
            tmp[i] = i;
        }
        Arrays.sort(tmp, (i, j) -> Integer.compare(nums[i], nums[j]));
        int res = 0;
        int min = size;
        for (Integer item : tmp) {
            res = Math.max(res, item - min);
            min = Math.min(min, item);
        }
        return res;
    }

}
