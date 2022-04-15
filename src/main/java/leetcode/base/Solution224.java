package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器
 * https://leetcode-cn.com/problems/basic-calculator/submissions/
 */
public class Solution224 {

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        Deque<Integer> symbol = new LinkedList<Integer>();
        symbol.push(1);
        int res = 0;
        int flag = 1;
        int i = 0;
        while (i < size) {
            if (chars[i] == ' ') {
                i++;
            } else if (chars[i] == '+') {
                flag = symbol.peek();
                i++;
            } else if (chars[i] == '-') {
                flag = -symbol.peek();
                i++;
            } else if (chars[i] == '(') {
                symbol.push(flag);
                i++;
            } else if (chars[i] == ')') {
                symbol.pop();
                i++;
            } else {
                long num = 0;
                while ((i < size) && Character.isDigit(chars[i])) {
                    num = num * 10 + (chars[i] - '0');
                    i++;
                }
                res += flag * num;
            }
        }
        return res;
    }

}
