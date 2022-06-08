package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词
 * https://leetcode.cn/problems/find-words-that-can-be-formed-by-characters/
 */
public class Solution1160 {

    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < chars.length(); ++i) {
            char key = chars.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int size = words.length;
        int res = 0;
        for (int i = 0; i < size; ++i) {
            Map<Character, Integer> subMap = new HashMap<Character, Integer>();
            for (int j = 0; j < words[i].length(); ++j) {
                char key = words[i].charAt(j);
                subMap.put(key, subMap.getOrDefault(key, 0) + 1);
            }
            boolean flag = true;
            for (Character key : subMap.keySet()) {
                if (subMap.getOrDefault(key, 0) > map.getOrDefault(key, 0)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += words[i].length();
            }
        }
        return res;
    }

}
