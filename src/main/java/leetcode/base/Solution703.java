package leetcode.base;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
public class Solution703 {

    private PriorityQueue<Integer> queue;
    private int limit;

    public Solution703(int k, int[] nums) {
        queue = new PriorityQueue<Integer>();
        limit = k;
        for (int i = 0; i < nums.length; ++i) {
            queue.add(nums[i]);
        }
    }

    public int add(int val) {
        queue.add(val);
        while (queue.size() > limit) {
            queue.poll();
        }
        return queue.peek();
    }

}
