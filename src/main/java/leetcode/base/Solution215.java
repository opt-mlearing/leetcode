package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return Integer.MIN_VALUE;
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        Deque<Integer> tmpDeque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int tmp = nums[i];
            while (!deque.isEmpty() && deque.peek() > nums[i]) {
                tmpDeque.push(deque.pop());
            }
            deque.push(nums[i]);
            while (!tmpDeque.isEmpty()) {
                deque.push(tmpDeque.pop());
            }
        }
        while (k > 1) {
            deque.pop();
            k--;
        }
        return deque.pop();
    }

}
