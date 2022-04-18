package leetcode.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 819. 最常见的单词
 * https://leetcode-cn.com/problems/most-common-word/
 */
public class Solution819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<String>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        StringBuilder builder = new StringBuilder();
        int maxFrequent = 0;
        // 这里一定需要多循环一次，因为最后一个单词不是遇到非字母字符结束的. 不能直接触发截取单词的els if分支.
        for (int i = 0; i <= paragraph.length(); ++i) {
            if (i < paragraph.length() && Character.isLetter(paragraph.charAt(i))) {
                builder.append(Character.toLowerCase(paragraph.charAt(i)));
            } else if (builder.length() > 0) {
                String word = builder.toString();
                if (!bannedSet.contains(word)) {
                    int frequent = map.getOrDefault(word, 0) + 1;
                    maxFrequent = Math.max(maxFrequent, frequent);
                    map.put(word, frequent);
                    ;
                }
                builder.setLength(0);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) == maxFrequent) {
                return key;
            }
        }
        return null;
    }

}
