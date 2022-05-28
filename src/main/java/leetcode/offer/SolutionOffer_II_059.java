package leetcode.offer;

import java.util.PriorityQueue;

/**
 * 剑指 Offer II 059. 数据流的第 K 大数值
 * https://leetcode-cn.com/problems/jBjn9C/
 */
public class SolutionOffer_II_059 {

    private PriorityQueue<Integer> queue;
    private int size;

    public SolutionOffer_II_059(int k, int[] nums) {
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
