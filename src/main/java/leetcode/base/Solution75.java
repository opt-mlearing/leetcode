package leetcode.base;

/**
 * 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class Solution75 {

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length;
        for (int i = 0; i < p2; i++) {
            while (i < p2 && nums[i] == 2) {
                swap(nums, i, --p2);
            }
            if (nums[i] == 0) {
                swap(nums, i, p0++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
