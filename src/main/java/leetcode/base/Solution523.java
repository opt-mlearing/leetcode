package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * https://leetcode.cn/problems/continuous-subarray-sum/
 */
public class Solution523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int size = nums.length;
        if (size < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < size; ++i) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

}
