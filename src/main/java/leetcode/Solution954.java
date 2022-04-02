package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二倍数对数组
 * https://leetcode-cn.com/problems/array-of-doubled-pairs/
 */
public class Solution954 {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        if (map.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        List<Integer> keyList = new ArrayList<Integer>(map.keySet());
        // 注意，这里一定需要compare(Math.abs(key1), Math.abs(key2)))
        // 正数生序， 负数降序排列.
        keyList.sort((key1, key2) -> Integer.compare(Math.abs(key1), Math.abs(key2)));
        for (int item : keyList) {
            int value1 = map.getOrDefault(item, 0);
            int value2 = map.getOrDefault(2 * item, 0);
            if (value1 > value2) {
                return false;
            }
            map.put(2 * item, value2 - value1);
        }
        return true;
    }

}
