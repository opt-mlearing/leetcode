package leetcode;

/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Solution283 {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }

    public void moveZeroes_double_search(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            nums[i - count] = nums[i];
        }
        for (int i = nums.length - count; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

}
