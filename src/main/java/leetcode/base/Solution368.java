package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * https://leetcode-cn.com/problems/largest-divisible-subset/
 */
public class Solution368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int lastNum = nums[0];
        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (maxSize < dp[i]) {
                maxSize = dp[i];
                lastNum = nums[i];
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        if (maxSize == 1) {
            res.add(nums[0]);
        } else {
            for (int i = size - 1; i >= 0 && maxSize > 0; --i) {
                if (maxSize == dp[i] && lastNum % nums[i] == 0) {
                    res.add(0, nums[i]);
                    lastNum = nums[i];
                    maxSize--;
                }
            }
        }
        return res;
    }

}
