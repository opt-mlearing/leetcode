package leetcode.base;

import java.util.Arrays;

/**
 * 414. 第三大的数
 * https://leetcode.cn/problems/third-maximum-number/
 *
 * @author: caogl
 * @date: 2022/6/26, 1:45
 **/
public class Solution414 {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = size - 2, diff = 1; i >= 0; --i) {
            if (nums[i] < nums[i + 1] && ++diff == 3) {
                return nums[i];
            }
        }
        return nums[size - 1];
    }

}
