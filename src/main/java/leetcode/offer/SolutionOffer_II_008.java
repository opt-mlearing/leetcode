package leetcode.offer;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * https://leetcode.cn/problems/2VG8Kg/
 */
public class SolutionOffer_II_008 {

    public int minSubArrayLen(int target, int[] nums) {
        int size = nums.length;
        int left = 0;
        int right = 0;
        // 注意提示.
        // 1 <= target <= 109
        // 1 <= nums.length <= 105
        // 1 <= nums[i] <= 105
        int res = 100001;
        int sum = 0;
        while (right < size) {
            sum += nums[right++];
            while (sum >= target && left <= right) {
                sum -= nums[left++];
                res = Math.min(res, right - left + 1);
            }
        }
        // res理论最大值nums.length- 0+ 1.
        return res > size ? 0 : res;
    }

}
