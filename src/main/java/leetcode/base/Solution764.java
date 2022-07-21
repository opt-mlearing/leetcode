package leetcode.base;

import java.util.Arrays;

/**
 * 764. 最大加号标志
 * https://leetcode.cn/problems/largest-plus-sign/
 *
 * @author: caogl
 * @date: 2022/7/22, 0:05
 **/
public class Solution764 {

    // 88ms/ 65.3mb
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // 0左| 1上| 2右| 3下
        int[][][] dp = new int[n][n][4];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], 1);
            }
        }
        for (int[] mine : mines) {
            int i = mine[0];
            int j = mine[1];
            Arrays.fill(dp[i][j], 0);
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                if (dp[i][j][0] == 0) {
                    continue;
                }
                dp[i][j][0] = dp[i - 1][j][0] + 1;
                dp[i][j][1] = dp[i][j - 1][1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                if (dp[i][j][2] == 0) {
                    continue;
                }
                dp[i][j][2] = dp[i + 1][j][2] + 1;
                dp[i][j][3] = dp[i][j + 1][3] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int len = Math.min(Math.min(dp[i][j][0], dp[i][j][1]), Math.min(dp[i][j][2], dp[i][j][3]));
                res = Math.max(res, len);
            }
        }
        return res;
    }

}
