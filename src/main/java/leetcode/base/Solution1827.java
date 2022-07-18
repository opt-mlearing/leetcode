package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1827. 最少操作使数组递增
 * https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/
 *
 * @author: caogl
 * @date: 2022/7/19, 0:43
 **/
public class Solution1827 {

    public int minOperations(int[] nums) {
        int size = nums.length;
        int res = 0;
        if (size == 0) {
            return res;
        }
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(nums[0]);
        for (int i = 1; i < size; ++i) {
            int tmp = nums[i];
            while (stack.peek() >= tmp) {
                tmp++;
                res++;
            }
            stack.push(tmp);
        }
        return res;
    }

}
