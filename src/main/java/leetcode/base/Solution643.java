package leetcode.base;

/**
 * 643. 子数组最大平均数 I
 * https://leetcode.cn/problems/maximum-average-subarray-i/
 *
 * @author: caogl
 * @date: 2022/6/19, 21:30
 **/
public class Solution643 {

    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int size = nums.length;
        int sum = 0;
        int res = Integer.MIN_VALUE;
        while (right < size) {
            sum += nums[right];
            while (right - left + 1 > k) {
                sum -= nums[left];
                left++;
            }
            if ((right - left + 1) == k) {
                res = Math.max(res, sum);
            }
            right++;
        }
        return (double) res / k;
    }

}
