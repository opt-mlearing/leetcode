package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * https://leetcode.cn/problems/QTMn0o/
 */
public class SolutionOffer_II_010 {

    // hash && 前缀和.
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 注意初始时，前缀为0的次数为1，千万不能忘记.
        map.put(0, 1);
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            res += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }

}
