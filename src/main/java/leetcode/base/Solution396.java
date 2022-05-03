package leetcode.base;

/**
 * 396. 旋转函数
 * https://leetcode-cn.com/problems/rotate-function/
 */
public class Solution396 {

    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int size = nums.length;
        int tmp = 0;
        for (int i = 0; i < size; ++i) {
            tmp += i * nums[i];
        }
        int[] dp = new int[size];
        dp[0] = tmp;
        int res = tmp;
        for (int i = 1; i < size; ++i) {
            dp[i] = dp[i - 1] + sum - size * nums[size - i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
