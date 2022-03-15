package leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false) - 1;
        if (start <= end && nums[start] == target && nums[end] == target) {
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean isLow) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if ((nums[mid] > target) || (isLow && nums[mid] >= target)) {
                res = mid;
                right = --mid;
            } else {
                left = ++mid;
            }
        }
        return res;
    }

}
