package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1021. 删除最外层的括号
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class Solution1021 {

    public String removeOuterParentheses(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                builder.append(chars[i]);
            }
            if (chars[i] == '(') {
                stack.push(chars[i]);
            }

        }
        return builder.toString();
    }

}
