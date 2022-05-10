package leetcode.base;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode.cn/problems/range-sum-query-immutable/
 */
public class NumArray303 {

    private int[] preSum;

    public NumArray303(int[] nums) {
        int size = nums.length;
        preSum = new int[size + 1];
        preSum[0] = 0;
        int sum = 0;
        for (int i = 1; i <= size; ++i) {
            sum += nums[i - 1];
            preSum[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */

}
