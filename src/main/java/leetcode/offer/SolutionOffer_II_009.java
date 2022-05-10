package leetcode.offer;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * https://leetcode.cn/problems/ZVAVXX/
 */
public class SolutionOffer_II_009 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int size = nums.length;
        int left = 0;
        int res = 0;
        int pro = 1;
        for (int right = 0; right < size; ++right) {
            pro *= nums[right];
            while (left <= right && k <= pro) {
                pro /= nums[left++];
            }
            res += (right - left + 1);
        }
        return res;
    }

}
