package leetcode.offer;

/**
 * 剑指 Offer II 013. 二维子矩阵的和
 * https://leetcode.cn/problems/O4NDxx/
 */
public class SolutionOffer_II_013 {

    private int[][] dp;

    public SolutionOffer_II_013(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row1][col2 + 1] - dp[row2 + 1][col1];
    }

}
