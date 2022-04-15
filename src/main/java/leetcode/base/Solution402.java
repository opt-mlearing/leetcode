package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 移掉 K 位数字
 * https://leetcode-cn.com/problems/remove-k-digits/
 */
public class Solution402 {

    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < chars.length; ++i) {
            while ((!stack.isEmpty()) && (k > 0) && (stack.peek() > chars[i])) {
                stack.pop();
                k--;
            }
            stack.push(chars[i]);
        }
        // 如果是单调增的情况,从最高位删除,栈内，自底向上非递增，那么从头删除.
        for (int i = 0; i < k; ++i) {
            stack.pop();
        }
        StringBuilder builder = new StringBuilder();
        boolean fromBegin = true;
        while (!stack.isEmpty()) {
            char item = stack.pollLast();
            if (item == '0' && fromBegin) {
                continue;
            }
            fromBegin = false;
            builder.append(item);
        }
        return builder.length() > 0 ? builder.toString() : "0";
    }

}
