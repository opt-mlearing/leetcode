package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 873. 最长的斐波那契子序列的长度
 * https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/
 */
public class Solution873 {

    private Map<Integer, Integer> positionMap;
    private Map<Integer, Integer> lengthMap;

    public int lenLongestFibSubseq(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        positionMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; ++i) {
            positionMap.put(arr[i], i);
        }
        lengthMap = new HashMap<Integer, Integer>();
        int res = 0;
        for (int j = 1; j < size - 1; ++j) {
            for (int k = j + 1; k < size; ++k) {
                int i = positionMap.getOrDefault(arr[k] - arr[j], -1);
                if (i != -1 && i < j) {
                    int len = lengthMap.getOrDefault(i * size + j, 2) + 1;
                    lengthMap.put(j * size + k, len);
                    res = Math.max(res, len);
                }
            }
        }
        return res;
    }

}
