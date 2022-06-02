package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 451. 根据字符出现频率排序
 * https://leetcode.cn/problems/sort-characters-by-frequency/submissions/
 */
public class Solution451 {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int size = s.length();
        int frequence = 0;
        for (int i = 0; i < size; ++i) {
            int count = map.getOrDefault(s.charAt(i), 0) + 1;
            frequence = Math.max(frequence, count);
            map.put(s.charAt(i), count);
        }
        StringBuilder[] bucket = new StringBuilder[frequence + 1];
        for (Character key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null) {
                bucket[count] = new StringBuilder();
            }
            bucket[count].append(key);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = frequence; i >= 0; --i) {
            if (bucket[i] != null) {
                int length = bucket[i].length();
                for (int j = 0; j < length; ++j) {
                    int count = i;
                    while (count > 0) {
                        builder.append(bucket[i].charAt(j));
                        count--;
                    }
                }
            }
        }
        return builder.toString();
    }

}
