package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最多能完成排序的块
 * https://leetcode-cn.com/problems/max-chunks-to-make-sorted/
 */
public class Solution769 {

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(arr[0]);
        for (int i = 1; i < n; ++i) {
            if (stack.peek() < arr[i]) {
                stack.push(arr[i]);
                continue;
            }
            int top = stack.peek();
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            stack.push(top);
        }
        return stack.size();
    }

}
