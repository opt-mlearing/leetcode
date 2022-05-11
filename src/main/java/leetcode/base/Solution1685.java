package leetcode.base;

/**
 * 1685. 有序数组中差绝对值之和
 * https://leetcode.cn/problems/sum-of-absolute-differences-in-a-sorted-array/
 */
public class Solution1685 {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int size = nums.length;
        int[] preSum = new int[size];
        int sum = 0;
        for (int i = 0; i < size; ++i) {
            sum += nums[i];
            preSum[i] = sum;
        }
        int[] res = new int[size];
        for (int i = 0; i < size; ++i) {
            int left = (i + 1) * nums[i] - preSum[i];
            int right = preSum[size - 1] - preSum[i] - (size - 1 - i) * nums[i];
            res[i] = left + right;
        }
        return res;
    }

}
