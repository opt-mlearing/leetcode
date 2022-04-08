package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最多能完成排序的块 II
 * https://leetcode-cn.com/problems/max-chunks-to-make-sorted-ii/
 */
public class Solution768 {

    public int maxChunksToSorted(int[] arr) {
        int size = arr.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(arr[0]);
        for (int i = 1; i < size; ++i) {
            if (stack.peek() <= arr[i]) {
                stack.push(arr[i]);
                continue;
            }
            int top = stack.peek();
            while (!stack.isEmpty() && arr[i] < stack.peek()) {
                stack.pop();
            }
            stack.push(top);
        }
        return stack.size();
    }

}
