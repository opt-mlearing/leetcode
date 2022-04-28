package leetcode.base;

import java.util.Arrays;

/**
 * 313. 超级丑数
 * https://leetcode-cn.com/problems/super-ugly-number/
 */
public class Solution313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int size = primes.length;
        int[] dp = new int[n + 1];
        int[] pointer = new int[size];
        // 开始的时候，所有指针全部指向0位置.
        Arrays.fill(pointer, 0);
        int[] nums = new int[size];
        // 最小的丑数.
        Arrays.fill(nums, 1);
        for (int i = 1; i <= n; ++i) {
            int value = minValue(nums);
            dp[i] = value;
            for (int j = 0; j < size; ++j) {
                if (value == nums[j]) {
                    pointer[j]++;
                    nums[j] = dp[pointer[j]] * primes[j];
                }
            }
        }
        return dp[n];
    }

    // 找到最小值.
    private int minValue(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

}
