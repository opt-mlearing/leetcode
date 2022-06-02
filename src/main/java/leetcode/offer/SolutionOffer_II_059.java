package leetcode.offer;

import java.util.PriorityQueue;

/**
 * 剑指 Offer II 059. 数据流的第 K 大数值
 * https://leetcode-cn.com/problems/jBjn9C/
 */
public class SolutionOffer_II_059 {

    // PriorityQueue
    private PriorityQueue<Integer> queue;
    private int size;

    public SolutionOffer_II_059(int k, int[] nums) {
        this.size = k;
        this.queue = new PriorityQueue<Integer>();
        for (int num : nums) {
            this.queue.offer(num);
        }
    }

    // 默认PriorityQueue是小顶堆,queue的顶指向最小, 那么只要维持queue的长度为k，则栈顶正好是第k大.
    public int add(int val) {
        this.queue.offer(val);
        while (this.queue.size() > this.size) {
            queue.poll();
        }
        return queue.peek();
    }

}
