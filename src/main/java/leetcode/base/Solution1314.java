package leetcode.base;

/**
 * 1314. 矩阵区域和
 * https://leetcode.cn/problems/matrix-block-sum/
 *
 * @author: caogl
 * @date: 2022/7/8, 0:00
 **/
public class Solution1314 {// 前缀和不加1.

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        // 初始化.
        dp[0][0] = mat[0][0];
        for (int i = 1; i < m; ++i) {
            dp[i][0] = dp[i - 1][0] + mat[i][0];
        }
        for (int i = 1; i < n; ++i) {
            dp[0][i] = dp[0][i - 1] + mat[0][i];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i][j];
            }
        }
        // 区域和
        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x1 = Math.max(0, i - k);
                int x2 = Math.min(m - 1, i + k);
                int y1 = Math.max(0, j - k);
                int y2 = Math.min(n - 1, j + k);
                if (x1 == 0 && y1 == 0) {
                    res[i][j] = dp[x2][y2];
                } else if (x1 == 0) {
                    res[i][j] = dp[x2][y2] - dp[x2][y1 - 1];
                } else if (y1 == 0) {
                    res[i][j] = dp[x2][y2] - dp[x1 - 1][y2];
                } else {
                    res[i][j] = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
                }
            }
        }
        return res;
    }

    // 二维前缀和
    public int[][] matrixBlockSum_1(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x1 = Math.max(0, i - k);
                int x2 = Math.min(m, i + k + 1);
                int y1 = Math.max(0, j - k);
                int y2 = Math.min(n, j + k + 1);
                res[i][j] = dp[x2][y2] - dp[x1][y2] - dp[x2][y1] + dp[x1][y1];
            }
        }
        return res;
    }

}
