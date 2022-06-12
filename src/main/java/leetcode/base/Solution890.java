package leetcode.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. 查找和替换模式
 * https://leetcode.cn/problems/find-and-replace-pattern/
 */
public class Solution890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<String>();
        for (String word : words) {
            if (match(word, pattern) && match(pattern, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean match(String word, String pattern) {
        int size1 = word.length();
        int size2 = pattern.length();
        if (size1 != size2) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < size1; ++i) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), word.charAt(i));
            } else if (map.get(pattern.charAt(i)) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
