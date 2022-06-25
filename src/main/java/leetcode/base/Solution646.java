package leetcode.base;

import java.util.Arrays;

/**
 * 646. 最长数对链
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/
 *
 * @author: caogl
 * @date: 2022/6/25, 22:51
 **/
public class Solution646 {

    public int findLongestChain(int[][] pairs) {
        // 注意，还是一定要排序一下的.
        Arrays.sort(pairs, (item1, item2) -> {
            if (item1[0] != item2[0]) {
                return Integer.compare(item1[0], item2[0]);
            } else {
                return Integer.compare(item1[1], item2[1]);
            }
        });
        int size = pairs.length;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        for (int j = 1; j < size; ++j) {
            for (int i = 0; i < j; ++i) {
                if (pairs[i][1] < pairs[j][0]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[size - 1];
    }

}
