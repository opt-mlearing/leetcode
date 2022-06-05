package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 037. 小行星碰撞
 * https://leetcode.cn/problems/XagZNi/
 */
public class SolutionOffer_II_037 {

    public int[] asteroidCollision(int[] asteroids) {
        int size = asteroids.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < size; ++i) {
            int asteroid = asteroids[i];
            boolean flag = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() + asteroid == 0) {
                    stack.poll();
                    flag = false;
                    break;
                } else if (stack.peek() < -asteroid) {
                    stack.poll();
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stack.push(asteroid);
            }
        }
        int len = stack.size();
        if (len == 0) {
            return new int[0];
        } else {
            int[] res = new int[len];
            for (int i = len - 1; i >= 0; --i) {
                res[i] = stack.poll();
            }
            return res;
        }
    }

}
