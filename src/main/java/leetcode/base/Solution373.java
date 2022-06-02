package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的 K 对数字
 * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/
 */
public class Solution373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue =
                new PriorityQueue<>(k, (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        int m = nums1.length;
        int n = nums2.length;
        // 其实只要保证[i, j],i== 0 && j== 0 一定在里面就ok.
        for (int i = 0; i < Math.min(k, m); ++i) {
            priorityQueue.offer(new int[]{i, 0});
        }
        List<List<Integer>> res = new ArrayList<>();
        // 选取出k个就结束.
        while (k > 0 && !priorityQueue.isEmpty()) {
            // 拿出最小的那个.
            int[] item = priorityQueue.poll();
            // index1+ 1的已经存在 priorityQueue中.
            int index1 = item[0];
            int index2 = item[1];
            List<Integer> subList = new ArrayList<>();
            subList.add(nums1[index1]);
            subList.add(nums2[index2]);
            res.add(subList);
            if (index2 + 1 < n) {
                priorityQueue.offer(new int[]{index1, index2 + 1});
            }
            k--;
        }
        return res;
    }

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
