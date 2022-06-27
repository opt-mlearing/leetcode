package leetcode.base;

/**
 * 53. 最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/submissions/
 *
 * @author: caogl
 * @date: 2022/6/28, 0:10
 **/
public class Solution53 {

    // dp[i], 以第i个数结尾的连续子串和最大.
    public int maxSubArray(int[] nums) {
        // dp[i- 1]>= 0, dp[i]= dp[i- 1]+ num[i]
        // dp[i- 1]< 0, dp[i]= nums[i];
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < size; ++i) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 优化，如上因为dp[i]只与dp[i- 1]相关.
    public int maxSubArray_2(int[] nums) {
        int preMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (preMax >= 0) {
                preMax = preMax + nums[i];
            } else {
                preMax = nums[i];
            }
            globalMax = Math.max(preMax, globalMax);
        }
        return globalMax;
    }

    public int maxSubArray_3(int[] nums) {
        // 注意，这里最小不能赋值Integer.MIN_VALUE,Integer.MIN_VALUE+负数就越界了.
        int preMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            preMax = Math.max(nums[i], preMax + nums[i]);
            globalMax = Math.max(globalMax, preMax);
        }
        return globalMax;
    }

}
