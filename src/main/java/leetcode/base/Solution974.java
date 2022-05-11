package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 * https://leetcode.cn/problems/subarray-sums-divisible-by-k/
 */
public class Solution974 {

    public int subarraysDivByK(int[] nums, int k) {
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int remainder = 0;
        int res = 0;
        for (int num : nums) {
            remainder += num;
            // 避免出现负数.
            remainder = (remainder % k + k) % k;
            res += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return res;
    }

}
