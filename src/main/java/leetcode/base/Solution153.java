package leetcode.base;

/**
 * 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution153 {

    // 二分法-方式1
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    // 二分法-方式2
    public int findMin_method1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                // mid的左边是有序的,升序.
                res = Math.min(res, nums[left]);
                left = mid + 1;
            } else {
                // mid的右边是有序的,升序.
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            }
        }
        return res;
    }

}
