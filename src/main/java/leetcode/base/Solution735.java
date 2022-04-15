package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 735. 行星碰撞
 * https://leetcode-cn.com/problems/asteroid-collision/
 */
public class Solution735 {

    public int[] asteroidCollision(int[] asteroids) {
        int size = asteroids.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < size; ++i) {
            boolean flag = true;
            // 需要继续循环下去.
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                if (-asteroids[i] > stack.peek()) {
                    stack.pop();
                } else if (-asteroids[i] == stack.peek()) {
                    stack.pop();
                    flag = false;
                    break;
                } else if (-asteroids[i] < stack.peek()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stack.push(asteroids[i]);
            }
        }
        // 需要判断是否为空.
        if (stack.isEmpty()) {
            return new int[0];
        } else {
            int[] res = new int[stack.size()];
            int i = 0;
            while (!stack.isEmpty()) {
                res[i++] = stack.pollLast();
            }
            return res;
        }
    }

}
