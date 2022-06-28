package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 1791. 找出星型图的中心节点
 * https://leetcode.cn/problems/find-center-of-star-graph/
 *
 * @author: caogl
 * @date: 2022/6/28, 22:00
 **/
public class Solution1791 {

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        int size = edges.length;
        for (int i = 0; i < size; ++i) {
            int[] item = edges[i];
            int a = item[0];
            int b = item[1];
            inDegree.put(a, inDegree.getOrDefault(a, 0) + 1);
            inDegree.put(b, inDegree.getOrDefault(b, 0) + 1);
        }
        int n = inDegree.size();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == n - 1) {
                return key;
            }
        }
        return -1;
    }

}
