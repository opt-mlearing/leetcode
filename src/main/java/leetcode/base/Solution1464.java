package leetcode.base;

import java.util.Arrays;

/**
 * 1464. 数组中两元素的最大乘积
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
 */
public class Solution1464 {

    public int maxProduct_1(int[] nums) {
        int size = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; ++i) {
            for (int j = i + 1; j < size; ++j) {
                res = Math.max(res, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return res;
    }

    public int maxProduct(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        return Math.max((nums[0] - 1) * (nums[1] - 1), (nums[size - 1] - 1) * (nums[size - 2] - 1));
    }

}
