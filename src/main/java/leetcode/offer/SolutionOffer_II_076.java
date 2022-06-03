package leetcode.offer;

import java.util.PriorityQueue;

/**
 * 剑指 Offer II 076. 数组中的第 k 大的数字
 * https://leetcode.cn/problems/xx4gT2/
 */
public class SolutionOffer_II_076 {

    private PriorityQueue<Integer> queue;

    public int findKthLargest(int[] nums, int k) {
        queue = new PriorityQueue<Integer>();
        int size = nums.length;
        for (int num : nums) {
            queue.offer(num);
        }
        k = queue.size() - k;
        while (k > 0) {
            queue.poll();
            k--;
        }
        return queue.peek();
    }

}
