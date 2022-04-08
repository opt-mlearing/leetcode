package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 17.21. 直方图的水量
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 */
public class Solution17_21 {

    // 双指针
    public int trap(int[] height) {
        int size = height.length;
        int left = 0;
        int right = size - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    // 单调栈
    public int trap_2(int[] height) {
        int size = height.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        int res = 0;
        for (int right = 0; right < size; ++right) {
            while (!stack.isEmpty() && height[right] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                res += (right - left - 1) * (Math.min(height[left], height[right]) - height[bottom]);
            }
            stack.push(right);
        }
        return res;
    }

    // 动态规划
    public int trap_1(int[] height) {
        int size = height.length;
        int[] left = new int[size];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; ++i) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        max = Integer.MIN_VALUE;
        int[] right = new int[size];
        for (int i = size - 1; i >= 0; --i) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }
        int res = 0;
        for (int i = 0; i < size; ++i) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

}
