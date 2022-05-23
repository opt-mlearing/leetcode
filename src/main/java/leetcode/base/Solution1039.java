package leetcode.base;

/**
 * 1039. 多边形三角剖分的最低得分
 * https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/
 */
public class Solution1039 {

    public int minScoreTriangulation(int[] values) {
        int size = values.length;
        int[][] dp = new int[size][size];
        for (int i = size - 1; i >= 0; --i) {
            for (int j = i + 2; j < size; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }
            }
        }
        return dp[0][size - 1];
    }

}
