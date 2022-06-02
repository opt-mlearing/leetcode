package leetcode.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 060. 出现频率最高的 k 个数字
 * https://leetcode.cn/problems/g5c51o/
 */
public class SolutionOffer_II_060 {

    private PriorityQueue<int[]> queue;

    public int[] topKFrequent(int[] nums, int k) {
        queue = new PriorityQueue<int[]>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        for (int key : map.keySet()) {
            queue.offer(new int[]{map.get(key), key});
        }
        int[] res = new int[k];
        for (int i = 0; i < k && !queue.isEmpty(); ++i) {
            res[i] = queue.poll()[1];
        }
        return res;
    }

}
