package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * https://leetcode-cn.com/problems/isomorphic-strings/
 */
public class Solution205 {

    // 注意，一一对应，即是双射.
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int size = s.length();
        for (int i = 0; i < size; ++i) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if ((s2t.containsKey(charS) && s2t.get(charS) != charT)
                    || (t2s.containsKey(charT) && t2s.get(charT) != charS)) {
                return false;
            }
            s2t.put(charS, charT);
            t2s.put(charT, charS);
        }
        return true;
    }

}
