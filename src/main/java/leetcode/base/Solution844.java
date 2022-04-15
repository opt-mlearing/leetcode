package leetcode.base;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 比较含退格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class Solution844 {

    public boolean backspaceCompare(String s, String t) {
        return afterBackString(s).equals(afterBackString(t));
    }

    private String afterBackString(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        Deque<Character> deque = new ArrayDeque<Character>();
        for (char item : chars) {
            if (item == '#') {
                if (deque.size() > 0) {
                    deque.pollLast();
                }
            } else {
                deque.offer(item);
            }
        }
        char[] res = new char[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            res[i++] = deque.poll();
        }
        return new String(res);
    }

}
