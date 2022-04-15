package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class Solution739 {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int index = 0;
        int[] res = new int[temperatures.length];
        while (index < temperatures.length) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[index]) {
                int pre = stack.pop();
                res[pre] = index - pre;
            }
            stack.push(index);
            ++index;
        }
        return res;
    }

}
