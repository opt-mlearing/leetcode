package leetcode;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Solution80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int low = 2;
        int high = 2;
        while (high < nums.length) {
            if (nums[low - 2] != nums[high]) {
                nums[low] = nums[high];
                low++;
            }
            ++high;
        }
        return low;
    }

}
