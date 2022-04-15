package leetcode.base;

/**
 * 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution26 {

    // 注意，题目中明确升序排序
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
