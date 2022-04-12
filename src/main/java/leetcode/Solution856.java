package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 856. 括号的分数
 * https://leetcode-cn.com/problems/score-of-parentheses/
 */
public class Solution856 {

    // 栈
    public int scoreOfParentheses(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(0);
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '(') {
                stack.push(0);
            } else {
                int m = stack.pop();
                int n = stack.pop();
                stack.push(n + Math.max(2 * m, 1));
            }
        }
        return stack.peek();
    }

    // 寻找核心
    public int scoreOfParentheses_3(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int level = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '(') {
                level++;
            } else {
                level--;
                if (chars[i - 1] == '(') {
                    res += (1 << level);
                }
            }
        }
        return res;
    }

}
