package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * https://leetcode.cn/problems/A1NYOS/
 */
public class SolutionOffer_II_011 {

    public int findMaxLength(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int preSum = 0;
        int res = 0;
        for (int i = 0; i < size; ++i) {
            preSum += nums[i];
            if (map.containsKey(preSum)) {
                int len = i - map.get(preSum);
                res = Math.max(res, len);
            } else {
                map.put(preSum, i);
            }
        }
        return res;
    }

}
