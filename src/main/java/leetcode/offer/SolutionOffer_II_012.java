package leetcode.offer;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * https://leetcode.cn/problems/tvdfij/
 */
public class SolutionOffer_II_012 {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int preSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (preSum * 2 + nums[i] == sum) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }

}
