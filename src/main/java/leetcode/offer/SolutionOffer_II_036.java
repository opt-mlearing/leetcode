package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 036. 后缀表达式
 * https://leetcode.cn/problems/8Zf90G/
 */
public class SolutionOffer_II_036 {

    public int evalRPN(String[] tokens) {
        int size = tokens.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < size; ++i) {
            if (tokens[i].equals("+")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first + second);
            } else if (tokens[i].equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (tokens[i].equals("*")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first * second);
            } else if (tokens[i].equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                int tmp = Integer.parseInt(tokens[i]);
                stack.push(tmp);
            }
        }
        return stack.peek();
    }

}
