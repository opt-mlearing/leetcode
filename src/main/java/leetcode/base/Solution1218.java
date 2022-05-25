package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class Solution1218 {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int num : arr) {
            int pre = num - difference;
            int count = map.getOrDefault(pre, 0) + 1;
            res = Math.max(res, count);
            map.put(num, count);
        }
        return res;
    }

}
