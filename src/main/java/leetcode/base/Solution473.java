package leetcode.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 473. 火柴拼正方形
 * https://leetcode.cn/problems/matchsticks-to-square/submissions/
 */
public class Solution473 {

    private Map<String, Boolean> memo;

    public boolean makesquare(int[] matchsticks) {
        memo = new HashMap<String, Boolean>();
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int size = matchsticks.length;
        Arrays.sort(matchsticks);
        // 一定需要从大到小排一下，若否会超时.
        for (int i = 0, j = size - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] edges = new int[4];
        return backTricking(0, matchsticks, edges, sum / 4);
    }

    public boolean backTricking(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }
        String key = Arrays.toString(edges);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && backTricking(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        memo.put(key, false);
        return false;
    }

}
