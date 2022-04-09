package leetcode.office;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 038. 每日温度
 * https://leetcode-cn.com/problems/iIQa4I/
 */
public class SolutionOffice2_038 {

    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < size; ++i) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

}
