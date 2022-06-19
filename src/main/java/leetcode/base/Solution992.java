package leetcode.base;

/**
 * 992. K 个不同整数的子数组
 * https://leetcode.cn/problems/subarrays-with-k-different-integers/
 *
 * @author: caogl
 * @date: 2022/6/19, 19:39
 **/
public class Solution992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysKDistinct(nums, k) - subarraysKDistinct(nums, k - 1);
    }

    // 求nums中小于等于k种类数字连续子数组的个数.
    private int subarraysKDistinct(int[] nums, int k) {
        int size = nums.length;
        // 提示：
        // 1 <= nums.length <= 2 * 104
        // 1 <= nums[i], k <= nums.length
        int[] frequent = new int[size + 1];
        int left = 0;
        int right = 0;
        int count = 0;
        int res = 0;
        while (right < size) {
            // 如果遇到等于0的情况，表示增加一种数字类型.
            if (frequent[nums[right]] == 0) {
                count++;
            }
            frequent[nums[right]]++;
            // 当count超过k的时候，left指针开始向右移动.
            while (count > k) {
                frequent[nums[left]]--;
                if (frequent[nums[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }

}
