package leetcode.base;

/**
 * 1292. 元素和小于等于阈值的正方形的最大边长
 * https://leetcode.cn/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 *
 * @author: caogl
 * @date: 2022/7/8, 0:41
 **/
public class Solution1292 {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = mat[0][0];
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
        // res为-1的时候表示不存在这样的正方形.
        int res = -1;
        for (int k = 0; k < Math.min(m, n); ++k) {
            for (int i = 0; i < m - k; ++i) {
                for (int j = 0; j < n - k; ++j) {
                    int tmp = threshold + 1;
                    if (i == 0 && j == 0) {
                        tmp = dp[i + k][j + k];
                    } else if (i == 0) {
                        tmp = dp[i + k][j + k] - dp[i + k][j - 1];
                    } else if (j == 0) {
                        tmp = dp[i + k][j + k] - dp[i - 1][j + k];
                    } else {
                        tmp = dp[i + k][j + k] - dp[i - 1][j + k] - dp[i + k][j - 1] + dp[i - 1][j - 1];
                    }
                    if (tmp <= threshold) {
                        res = Math.max(res, k);
                    }
                }
            }
        }
        return res == -1 ? 0 : res + 1;
    }

    public int maxSideLength_1(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int left = 1;
        int right = Math.min(m, n);
        int res = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            boolean isFind = false;
            for (int i = 1; i <= m - mid + 1; ++i) {
                for (int j = 1; j <= n - mid + 1; ++j) {
                    if (getRect(dp, i, j, i + mid - 1, j + mid - 1) <= threshold) {
                        isFind = true;
                    }
                }
            }
            if (isFind) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private int getRect(int[][] dp, int x1, int y1, int x2, int y2) {
        return dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
    }

    public int maxSideLength_2(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int res = 0;
        for (int k = 1; k <= Math.min(m, n); ++k) {
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (i - k >= 0 && j - k >= 0) {
                        int tmp = dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k];
                        if (tmp <= threshold) {
                            res = Math.max(res, k);
                        }
                    }
                }
            }
        }
        return res;
    }

}
