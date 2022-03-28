package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Solution42 {

    public int trap_stack(int[] height) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int i = 0;
        int res = 0;
        while (i < height.length) {
            while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                int top = deque.pop();
                if (deque.isEmpty()) {
                    break;
                }
                int left = deque.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                res += currHeight * currWidth;
            }
            deque.push(i++);
        }
        return res;
    }

    public int trap_dp(int[] height) {
        int size = height.length;
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = height[0];
        for (int i = 1; i < size; ++i) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        right[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; --i) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < size; ++i) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

}
