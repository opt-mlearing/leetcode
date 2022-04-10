package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 682. 棒球比赛
 * https://leetcode-cn.com/problems/baseball-game/
 */
public class Solution682 {

    public int calPoints(String[] ops) {
        Deque<Integer> stack = new LinkedList<Integer>();
        for (String str : ops) {
            if (str.equals("C") && !stack.isEmpty()) {
                stack.pop();
            } else if (str.equals("D") && !stack.isEmpty()) {
                stack.push(stack.peek() * 2);
            } else if (str.equals("+") && !stack.isEmpty()) {
                Integer top = stack.pop();
                Integer subTop = stack.peek();
                stack.push(top);
                stack.push(top + subTop);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}
