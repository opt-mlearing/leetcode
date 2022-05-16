package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 2006. 差的绝对值为 K 的数对数目
 * https://leetcode.cn/problems/count-number-of-pairs-with-absolute-difference-k/
 */
public class Solution2006 {

    public int countKDifference(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            res += map.getOrDefault(num - k, 0) + map.getOrDefault(num + k, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }

}
