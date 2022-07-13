package leetcode.base;

import java.util.Arrays;

/**
 * 787. K 站中转内最便宜的航班
 * https://leetcode.cn/problems/cheapest-flights-within-k-stops/
 *
 * @author caogaoli
 * @date 2022/7/13 17:40
 */
public class Solution787 {

    // 1 <= price[i] <= 10000
    // 1 <= n <= 100
    // 如题中已知，则可假设最大值1000001.
    private static final int MAX_VALUES = 1000001;

    // 最多经过k站台, 那么就是第k+到达dst最小.
    // dp[i][j]表示在第i步时到达j地点的最小开销.
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(dp[i], MAX_VALUES);
        }
        dp[0][src] = 0;
        for (int i = 1; i <= k + 1; ++i) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + cost);
            }
        }
        int res = MAX_VALUES;
        for (int i = 1; i <= k + 1; ++i) {
            res = Math.min(res, dp[i][dst]);
        }
        return res == MAX_VALUES ? -1 : res;
    }

}
