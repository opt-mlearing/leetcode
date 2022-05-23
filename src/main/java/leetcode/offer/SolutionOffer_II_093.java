package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 093. 最长斐波那契数列
 * https://leetcode.cn/problems/Q91FMA/
 */
public class SolutionOffer_II_093 {

    public int lenLongestFibSubseq(int[] arr) {
        int size = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; ++i) {
            indexMap.put(arr[i], i);
        }
        Map<Integer, Integer> lengthMap = new HashMap<Integer, Integer>();
        int res = 0;
        for (int k = 0; k < size; ++k) {
            for (int j = 0; j < k; ++j) {
                int i = indexMap.getOrDefault(arr[k] - arr[j], -1);
                if (i >= 0 && i < j) {
                    int len = lengthMap.getOrDefault(i * size + j, 2) + 1;
                    lengthMap.put(j * size + k, len);
                    res = Math.max(res, len);
                }
            }
        }
        return res;
    }

}
