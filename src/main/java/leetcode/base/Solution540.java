package leetcode.base;

/**
 * 540. 有序数组中的单一元素
 * https://leetcode.cn/problems/single-element-in-a-sorted-array/
 */
public class Solution540 {

    public int singleNonDuplicate(int[] nums) {
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
