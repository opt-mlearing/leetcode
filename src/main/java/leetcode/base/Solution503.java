package leetcode.base;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 下一个更大元素 II
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class Solution503 {

    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        Arrays.fill(res, -1);
        int index = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        // 循环数组，拉直就是了，2倍足够.
        while (index < (2 * size)) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index % size]) {
                int tmp = stack.pop();
                res[tmp] = nums[index % size];
            }
            stack.push(index % size);
            index++;
        }
        return res;
    }

}
