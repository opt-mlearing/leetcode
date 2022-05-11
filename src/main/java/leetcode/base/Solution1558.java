package leetcode.base;

/**
 * 1588. 所有奇数长度子数组的和
 * https://leetcode.cn/problems/sum-of-all-odd-length-subarrays/
 */
public class Solution1558 {

    public int sumOddLengthSubarrays(int[] arr) {
        int size = arr.length;
        int[] preSum = new int[size + 1];
        for (int i = 1; i <= size; ++i) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        int sum = 0;
        for (int i = 0; i < size; ++i) {
            for (int len = 1; len + i <= size; len += 2) {
                sum += preSum[i + len] - preSum[i];
            }
        }
        return sum;
    }

}
