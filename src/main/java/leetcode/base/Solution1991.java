package leetcode.base;

/**
 * 1991. 找到数组的中间位置
 * https://leetcode.cn/problems/find-the-middle-index-in-array/
 */
public class Solution1991 {

    public int findMiddleIndex(int[] nums) {
        int total = 0;
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            total += nums[i];
        }
        int preSum = 0;
        for (int i = 0; i < size; ++i) {
            if (2 * preSum + nums[i] == total) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }

}
