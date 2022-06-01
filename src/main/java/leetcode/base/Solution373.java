package leetcode.base;

import java.util.*;

public class Solution373 {

    private Deque<int[]> stack;

    // 会超时.
    public List<List<Integer>> kSmallestPairs_Timeout(int[] nums1, int[] nums2, int k) {
        stack = new LinkedList<int[]>();
        Deque<int[]> tmp = new LinkedList<int[]>();
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                while (!stack.isEmpty() && stack.peek()[0] + stack.peek()[1] > nums1[i] + nums2[j]) {
                    tmp.push(stack.poll());
                }
                stack.push(new int[]{nums1[i], nums2[j]});
                while (!tmp.isEmpty()) {
                    stack.push(tmp.poll());
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!stack.isEmpty() && k > 0) {
            int[] item = stack.pollLast();
            List<Integer> subList = new ArrayList<>();
            subList.add(item[0]);
            subList.add(item[1]);
            res.add(subList);
            k--;
        }
        return res;
    }

}
