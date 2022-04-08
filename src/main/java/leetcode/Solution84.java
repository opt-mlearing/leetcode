package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class Solution84 {

    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] pre = new int[size];
        for (int i = 0; i < size; ++i) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            pre[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        int[] post = new int[size];
        for (int i = size - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                stack.pop();
            }
            post[i] = (stack.isEmpty() ? size : stack.peek());
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < size; ++i) {
            res = Math.max(res, heights[i] * (post[i] - pre[i] - 1));
        }
        return res;
    }

}
