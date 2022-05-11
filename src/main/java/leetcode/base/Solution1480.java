package leetcode.base;

/**
 * 1480. 一维数组的动态和
 * https://leetcode.cn/problems/running-sum-of-1d-array/
 */
public class Solution1480 {

    public int[] runningSum(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        res[0] = nums[0];
        for (int i = 1; i < size; ++i) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }

}
