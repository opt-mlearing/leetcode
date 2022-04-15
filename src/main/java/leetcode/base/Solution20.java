package leetcode.base;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Solution20 {

    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> deque = new LinkedList<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char tmp = s.charAt(i);
            if (map.containsKey(tmp)) {
                // 存进来的是右括号类型.
                if (deque.isEmpty() || deque.peek() != map.get(tmp)) {
                    return false;
                }
                deque.pop();
            } else {
                // 先存左括号类型.
                // 存进来的是左括号类型.
                deque.push(tmp);
            }
        }
        return deque.isEmpty();
    }

}
