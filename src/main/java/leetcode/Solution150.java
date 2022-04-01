package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/submissions/
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (String token : tokens) {
            boolean strIsDigit = isDigit(token);
            // 注意是先进后出.
            if (strIsDigit) {
                deque.push(Integer.parseInt(token));
            } else {
                assert deque.size() > 1;
                int second = deque.poll();
                int first = deque.poll();
                if (token.equals("+")) {
                    deque.push(first + second);
                } else if (token.equals("-")) {
                    deque.push(first - second);
                } else if (token.equals("*")) {
                    deque.push(first * second);
                } else if (token.equals("/")) {
                    int tmp = first / second;
                    deque.push(tmp);
                }
            }
        }
        assert deque.size() == 1;
        return deque.poll();
    }

    // 判断字符串是否为数字.
    private boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

}
