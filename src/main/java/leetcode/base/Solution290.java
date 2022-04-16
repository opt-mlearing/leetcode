package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * https://leetcode-cn.com/problems/word-pattern/
 */
public class Solution290 {

    public boolean wordPattern(String pattern, String s) {
        if (pattern == null && s == null) {
            return true;
        } else if ((pattern == null && s != null) || (pattern != null && s == null)) {
            return false;
        }
        return doWordPattern(pattern, s);
    }

    private boolean doWordPattern(String pattern, String s) {
        Map<Character, String> p2s = new HashMap<Character, String>();
        Map<String, Character> s2p = new HashMap<String, Character>();
        int left = 0;
        for (int i = 0; i < pattern.length(); ++i) {
            char pChar = pattern.charAt(i);
            // 判断pattern还没结束， s是否已经一一匹配结束.
            if (left >= s.length()) {
                return false;
            }
            int right = left;
            while (right < s.length() && s.charAt(right) != ' ') {
                right++;
            }
            String sSub = s.substring(left, right);
            // 注意，字符串比较内容，用equals().
            if ((p2s.containsKey(pChar) && !p2s.get(pChar).equals(sSub)) || (s2p.containsKey(sSub) && s2p.get(sSub) != pChar)) {
                return false;
            }
            p2s.put(pChar, sSub);
            s2p.put(sSub, pChar);
            left = right + 1;
        }
        // 正常情况下pattern 和 s若一一全部匹配成功，那么此时left== s.length()- 1;
        return left >= s.length();
    }

}
