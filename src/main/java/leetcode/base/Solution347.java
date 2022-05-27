package leetcode.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 347. 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int size = map.size();
        Num[] datas = new Num[size];
        int index = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);
            datas[index++] = new Num(key, count);
        }
        Arrays.sort(datas, (num1, num2) -> Integer.compare(num2.count, num1.count));
        int len = Math.min(k, size);
        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            res[i] = datas[i].num;
        }
        return res;
    }

    private static class Num {
        private int num;
        private int count;

        public Num(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

}
