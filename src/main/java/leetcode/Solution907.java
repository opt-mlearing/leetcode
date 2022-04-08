package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 子数组的最小值之和
 * https://leetcode-cn.com/problems/sum-of-subarray-minimums/
 */
public class Solution907 {

    private static final long N = (long) 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int size = arr.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] pre = new int[size];
        for (int i = 0; i < size; ++i) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            pre[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        int[] post = new int[size];
        for (int i = size - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            post[i] = (stack.isEmpty() ? size : stack.peek());
            stack.push(i);
        }
        long res = 0;
        for (int i = 0; i < size; ++i) {
            res += (long) (i - pre[i]) * (post[i] - i) % N * arr[i] % N;
            res %= N;
        }
        return (int) res;
    }

}
