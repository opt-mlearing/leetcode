package leetcode.base;

import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * https://leetcode.cn/problems/sort-array-by-parity/
 *
 * @author: caogl
 * @date: 2022/6/24, 2:18
 **/
public class Solution905 {

    public int[] sortArrayByParity(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        while (left < right) {
            while (left <= right && nums[left] % 2 == 0) {
                left++;
            }
            while (left <= right && nums[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return nums;
    }

}
