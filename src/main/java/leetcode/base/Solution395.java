package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * @author: caogl
 * @date: 2022/6/20, 2:18
 **/
public class Solution395 {

    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int i = 1; i <= 26; ++i) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int left = 0;
            int right = 0;
            int size = s.length();
            int kind = 0;
            while (right < size) {
                char tmp = s.charAt(right);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                if (map.getOrDefault(tmp, 0) == k) {
                    kind++;
                }
                while (map.keySet().size() > i) {
                    char leftChar = s.charAt(left);
                    if (map.getOrDefault(leftChar, 0) == k) {
                        kind--;
                    }
                    map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                    if (map.getOrDefault(leftChar, 0) == 0) {
                        map.remove(leftChar);
                    }
                    left++;
                }
                int curr = map.keySet().size();
                if (curr == i && kind == i) {
                    res = Math.max(res, right - left + 1);
                }
                right++;
            }
        }
        return res;
    }

}
