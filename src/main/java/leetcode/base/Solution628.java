package leetcode.base;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * https://leetcode.cn/problems/maximum-product-of-three-numbers/
 *
 * @author: caogl
 * @date: 2022/6/24, 2:07
 **/
public class Solution628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        return Math.max(nums[0] * nums[1] * nums[size - 1], nums[size - 1] * nums[size - 2] * nums[size - 3]);
    }

}
