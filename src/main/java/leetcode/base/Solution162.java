package leetcode.base;

/**
 * 寻找峰值
 * https://leetcode-cn.com/problems/find-peak-element/
 */
public class Solution162 {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}
