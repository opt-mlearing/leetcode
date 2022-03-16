package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 颠倒字符串中的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class Solution151 {

    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != ' ' && s.charAt(right) != ' ') {
                break;
            } else if (s.charAt(left) == ' ') {
                left++;
            } else if (s.charAt(right) == ' ') {
                right--;
            }
        }
        Deque<String> deque = new ArrayDeque<String>();
        StringBuffer buffer = new StringBuffer();
        while (left <= right) {
            if (s.charAt(left) != ' ') {
                buffer.append(s.charAt(left));
            } else {
                if (buffer.length() > 0) {
                    deque.push(buffer.toString());
                    buffer.setLength(0);
                }
            }
            ++left;
        }
        if (buffer.length() > 0) {
            deque.push(buffer.toString());
        }
        String result = new String();
        while (!deque.isEmpty()) {
            result += deque.pop() + " ";
        }
        return result.substring(0, result.length() - 1);
    }

}
