package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 862. 和至少为 K 的最短子数组
 * https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/
 */
public class Solution862 {

    public int shortestSubarray(int[] nums, int k) {
        int size = nums.length;
        // 注意，这里元素累加可能会Integer溢出，故此选用long.
        long[] preSum = new long[size + 1];
        // 前缀和.
        for (int i = 0; i < size; ++i) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int res = size + 1;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < size + 1; ++i) {
            while (!stack.isEmpty() && preSum[stack.peek()] >= preSum[i]) {
                stack.poll();
            }
            while (!stack.isEmpty() && preSum[i] - preSum[stack.peekLast()] >= k) {
                res = Math.min(res, i - stack.pollLast());
            }
            stack.push(i);
        }
        return res == size + 1 ? -1 : res;
    }

}
