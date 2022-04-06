package leetcode;

import java.util.Arrays;

/**
 * 最短无序连续子数组
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class Solution581 {

    // 一次遍历
    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        int right = -1;
        int n = nums.length;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (maxVal > nums[i]) {
                right = i;
            } else {
                maxVal = nums[i];
            }
            if (minVal < nums[n - 1 - i]) {
                left = n - 1 - i;
            } else {
                minVal = nums[n - 1 - i];
            }
        }
        return left == -1 ? 0 : right - left + 1;

    }

    // 排序
    public int findUnsortedSubarray_by_sort(int[] nums) {
        if (isSort(nums)) {
            return 0;
        }
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(tmp);
        int left = 0;
        while (nums[left] == tmp[left] && left < nums.length) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == tmp[right] && right >= 0) {
            right--;
        }
        return right - left + 1;

    }

    private boolean isSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
