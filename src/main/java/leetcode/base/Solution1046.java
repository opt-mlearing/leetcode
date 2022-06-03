package leetcode.base;

import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 * https://leetcode.cn/problems/last-stone-weight/
 */
public class Solution1046 {

    private PriorityQueue<Integer> queue;

    // java PriorityQueue 默认是最小堆，需要重写compare过程.
    public int lastStoneWeight(int[] stones) {
        queue = new PriorityQueue<Integer>((item1, item2) -> item2 - item1);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            if (first != second) {
                queue.offer(first - second);
            }
        }
        return queue.size() == 0 ? 0 : queue.peek();
    }

}
