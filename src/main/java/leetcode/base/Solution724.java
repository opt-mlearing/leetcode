package leetcode.base;

/**
 * 724. 寻找数组的中心下标
 * https://leetcode.cn/problems/find-pivot-index/
 */
public class Solution724 {

    public int pivotIndex(int[] nums) {
        int size = nums.length;
        int total = 0;
        for (int i = 0; i < size; ++i) {
            total += nums[i];
        }
        int preSum = 0;
        for (int i = 0; i < size; ++i) {
            if (preSum * 2 + nums[i] == total) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }

}
