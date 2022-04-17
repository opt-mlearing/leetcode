package leetcode.base;

/**
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class Solution209 {

    // 滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = nums.length <= Integer.MAX_VALUE - 1 ? nums.length + 1 : Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            // 注意，这里只要出现大于等于target的情况，就需要进行left移动及其其他相关操作.
            while (sum >= target && left <= right) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return res > nums.length ? 0 : res;
    }

}
