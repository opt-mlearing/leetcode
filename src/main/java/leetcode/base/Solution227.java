package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 * https://leetcode-cn.com/problems/basic-calculator-ii/submissions/
 */
public class Solution227 {

    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList<Integer>();
        char[] chars = s.toCharArray();
        int num = 0;
        // 注意，这里前置为‘+’无影响.
        char preOperation = '+';
        for (int i = 0; i < chars.length; ++i) {
            char item = chars[i];
            if (Character.isDigit(item)) {
                num = num * 10 + (item - '0');
            }
            if ((!Character.isDigit(item) && item != ' ') || (i == chars.length - 1)) {
                switch (preOperation) {
                    case '+':
                        nums.push(num);
                        break;
                    case '-':
                        nums.push(-num);
                        break;
                    case '*':
                        nums.push(nums.pop() * num);
                        break;
                    case '/':
                        nums.push((nums.pop() / num));
                        break;
                }
                preOperation = item;
                num = 0;
            }
        }
        int sum = 0;
        while (!nums.isEmpty()) {
            sum += nums.pop();
        }
        return sum;
    }

}
