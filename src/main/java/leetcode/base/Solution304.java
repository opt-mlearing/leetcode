package leetcode.base;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * https://leetcode.cn/problems/range-sum-query-2d-immutable/
 *
 * @author: caogl
 * @date: 2022/7/8, 0:45
 **/
public class Solution304 {

    private int[][] dp;

    public Solution304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
    
}
