package leetcode.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2103. 环和杆
 * https://leetcode.cn/problems/rings-and-rods/
 */
public class Solution2103 {

    public int countPoints(String rings) {
        int size = rings.length();
        Map<Integer, Set<Character>> map = new HashMap<>();
        int index = 0;
        while (index < size) {
            char color = rings.charAt(index);
            int key = rings.charAt(++index) - '0';
            index++;
            Set<Character> set = map.getOrDefault(key, new HashSet<Character>());
            set.add(color);
            map.put(key, set);
        }
        int res = 0;
        for (int key : map.keySet()) {
            if (map.get(key).size() == 3) {
                res++;
            }
        }
        return res;
    }

}
