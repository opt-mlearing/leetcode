package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 */
public class Solution560 {

    // 暴力枚举.
    public int subarraySum_1(int[] nums, int k) {
        int size = nums.length;
        int res = 0;
        for (int i = 0; i < size; ++i) {
            int sum = 0;
            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    // 前缀和.
    public int subarraySum(int[] nums, int k) {
        // 前缀和，出现次数.
        Map<Integer, Integer> preSumMap = new HashMap<Integer, Integer>();
        preSumMap.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;
            res += preSumMap.getOrDefault(sum - k, 0);
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

}