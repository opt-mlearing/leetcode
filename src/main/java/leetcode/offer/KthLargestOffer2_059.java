package leetcode.offer;

import java.util.PriorityQueue;

public class KthLargestOffer2_059 {

    private PriorityQueue<Integer> queue;
    private int size;

    public KthLargestOffer2_059(int k, int[] nums) {
        queue = new PriorityQueue<Integer>();
        size = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // 使用优先队列，先增加再删除.
        queue.add(val);
        if (queue.size() > size) {
            queue.poll();
        }
        return queue.peek();
    }

}
