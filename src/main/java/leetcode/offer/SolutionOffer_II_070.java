package leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 * https://leetcode.cn/problems/skFtm2/
 *
 * @author caogaoli
 * @date 2022/7/15 15:21
 */
public class SolutionOffer_II_070 {

    public int singleNonDuplicate(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left];
    }

}
