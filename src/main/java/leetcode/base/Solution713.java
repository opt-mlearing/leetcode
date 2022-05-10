package leetcode.base;

/**
 * 713. 乘积小于 K 的子数组
 * https://leetcode.cn/problems/subarray-product-less-than-k/
 */
public class Solution713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int size = nums.length;
        int left = 0;
        int right = 0;
        int product = 1;
        int res = 0;
        while (right < size) {
            product *= nums[right];
            while (product >= k && left <= right) {
                product /= nums[left++];
            }
            res += (right - left + 1);
            right++;
        }
        return res;
    }

}
