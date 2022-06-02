package leetcode.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 061. 和最小的 k 个数对
 * https://leetcode.cn/problems/qn8gGX/submissions/
 */
public class SolutionOffer_II_061 {

    // PriorityQueue默认是小顶堆.
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(k,
                (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); ++i) {
            queue.offer(new int[]{i, 0});
        }
        List<List<Integer>> res = new ArrayList<>();
        while (k > 0 && !queue.isEmpty()) {
            int[] item = queue.poll();
            int index1 = item[0];
            int index2 = item[1];
            List<Integer> subList = new ArrayList<Integer>();
            subList.add(nums1[index1]);
            subList.add(nums2[index2]);
            res.add(subList);
            // 注意这里一定需要判断是否越界.
            if (index2 + 1 < n) {
                queue.offer(new int[]{index1, index2 + 1});
            }
            k--;
        }
        return res;
    }

}
