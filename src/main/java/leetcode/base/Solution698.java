package leetcode.base;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 */
public class Solution698 {

    // dp
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[n - 1] > target) {
            return false;
        }
        int size = 1 << n;
        boolean[] dp = new boolean[size];
        dp[0] = true;
        int[] currSum = new int[size];
        for (int i = 0; i < size; ++i) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) == 0) {
                    int next = i | (1 << j);
                    if (dp[next]) {
                        continue;
                    }
                    if (currSum[i] % target + nums[j] <= target) {
                        currSum[next] = currSum[i] + nums[j];
                        dp[next] = true;
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[size - 1];
    }

    private int[] buckets;

    public boolean canPartitionKSubsets_backTracking(int[] nums, int k) {
        int size = nums.length;
        if (size < k) {
            return false;
        }
        buckets = new int[k];
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        // 做一下降序排列，时间开销会小很多.
        for (int i = 0, j = size - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // 根据题目意思，nums中都是正整数.
        if (nums[size - 1] > target) {
            return false;
        }
        buckets = new int[k];
        return backTracking(nums, k, 0, target);
    }

    private boolean backTracking(int[] nums, int k, int index, int target) {
        if (index >= nums.length) {
            return true;
        }
        for (int i = 0; i < k; ++i) {
            if (buckets[i] + nums[index] > target) {
                continue;
            }
            if (i > 0 && buckets[i] == buckets[i - 1]) {
                continue;
            }
            buckets[i] += nums[index];
            // first fit.
            if (backTracking(nums, k, index + 1, target)) {
                return true;
            }
            buckets[i] -= nums[index];
        }
        return false;
    }

}
