package leetcode.base;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class Solution496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int m = nums1.length;
        int n = nums2.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = n - 1; i >= 0; --i) {
            // 栈中存最大的.
            while (!stack.isEmpty() && (stack.peek() <= nums2[i])) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public int[] nextGreaterElement_1(int[] nums1, int[] nums2) {
        // 构建hash映射.
        Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; ++i) {
            mapping.put(nums2[i], i);
        }
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] bigNums = new int[nums2.length];
        Arrays.fill(bigNums, -1);
        for (int i = 0; i < nums2.length; ++i) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int key = stack.poll();
                int index = mapping.get(key);
                bigNums[index] = nums2[i];
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = bigNums[mapping.get(nums1[i])];
        }
        return res;
    }

}
