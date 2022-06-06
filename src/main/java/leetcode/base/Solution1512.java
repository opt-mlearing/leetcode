package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 1512. 好数对的数目
 * https://leetcode.cn/problems/number-of-good-pairs/submissions/
 */
public class Solution1512 {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            int num = map.get(key);
            if (key > 0) {
                res += (num * (num - 1)) / (2 * 1);
            }
        }
        return res;
    }

}
