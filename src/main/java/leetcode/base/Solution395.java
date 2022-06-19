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
        // 一共26个小写字母.
        for (int kind = 1; kind <= 26; ++kind) {
            int left = 0;
            int right = 0;
            int count = 0;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            while (right < s.length()) {
                char tmp = s.charAt(right);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                if (map.getOrDefault(tmp, 0) == k) {
                    count++;
                }
                while (map.keySet().size() > kind) {
                    char leftChar = s.charAt(left);
                    if (map.getOrDefault(leftChar, 0) == k) {
                        count--;
                    }
                    map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                    if (map.getOrDefault(leftChar, 0) == 0) {
                        map.remove(leftChar);
                    }
                    left++;
                }
                int mapSize = map.keySet().size();
                // map中每一个元素的最小出现频次都不少于k次.
                if (mapSize == kind && count == kind) {
                    res = Math.max(res, right - left + 1);
                }
                right++;
            }
        }
        return res;
    }

}
