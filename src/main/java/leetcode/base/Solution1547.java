package leetcode.base;

import java.util.Arrays;

/**
 * 1547. 切棍子的最小成本
 * https://leetcode-cn.com/problems/minimum-cost-to-cut-a-stick/
 */
public class Solution1547 {

    public int minCost(int n, int[] cuts) {
        int size = cuts.length;
        int[] values = new int[size + 2];
        values[0] = 0;
        values[size + 1] = n;
        for (int i = 0; i < size; ++i) {
            values[i + 1] = cuts[i];
        }
        Arrays.sort(values);
        int[][] dp = new int[size + 2][size + 2];
        for (int i = size; i >= 1; --i) {
            for (int j = i; j <= size; ++j) {
                dp[i][j] = (i == j ? 0 : Integer.MAX_VALUE);
                for (int k = i; k <= j; ++k) {
                    dp[i][j] = Math.min(dp[i][k - 1] + dp[k + 1][j], dp[i][j]);
                }
                dp[i][j] += values[j + 1] - values[i - 1];
            }
        }
        return dp[1][size];
    }

}
