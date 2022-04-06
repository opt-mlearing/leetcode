package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 132 模式
 * https://leetcode-cn.com/problems/132-pattern/
 */
public class Solution456 {

    public boolean find132pattern(int[] nums) {
        int size = nums.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = size - 1; i >= 0; --i) {
            if (nums[i] < max) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                max = Math.max(max, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }

}
