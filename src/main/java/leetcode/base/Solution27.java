package leetcode.base;

/**
 * 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}
