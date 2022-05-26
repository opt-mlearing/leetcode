package leetcode.offer;

import java.util.List;

/**
 * 剑指 Offer II 100. 三角形中最小路径之和
 * https://leetcode.cn/problems/IlPe0q/
 */
public class SolutionOffer_II_100 {

    // 一维动态规划.
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; ++i) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j >= 1; --j) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int res = dp[0];
        for (int i = 1; i < size; ++i) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    // 二维动态规划.
    public int minimumTotal_2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; ++i) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int res = dp[size - 1][0];
        for (int i = 1; i < triangle.get(size - 1).size(); ++i) {
            res = Math.min(res, dp[size - 1][i]);
        }
        return res;
    }

}
