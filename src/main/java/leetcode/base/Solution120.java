package leetcode.base;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode.cn/problems/triangle/
 *
 * @author: caogl
 * @date: 2022/7/6, 0:43
 **/
public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        // dp初始化.
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                dp[i][j] = triangle.get(i).get(j);
            }
            for (int j = triangle.get(i).size(); j < size; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < size; ++i) {
            dp[i][0] += dp[i - 1][0];
            for (int j = 1; j < triangle.get(i).size(); ++j) {
                dp[i][j] += Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        int res = dp[dp.length - 1][0];
        for (int i = 1; i < size; ++i) {
            res = Math.min(res, dp[dp.length - 1][i]);
        }
        return res;
    }

    public int minimumTotal_1(List<List<Integer>> triangle) {
        // dp[i][j] 表示此时路径和最小
        // dp[i][j]= triangle.get(i).get(j)+ min(dp[i- 1][j], dp[i-1][j- 1]);
        // 注意边界条件. j= 0, dp[i][j]= triangle.get(i).get(0)+ dp[i-1][0];
        // j= triangle.get(i).size()- 1, dp[i][j]= triangle.get(i).get(j)+ dp[i- 1][i- 1];
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); ++i) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < triangle.get(i).size() - 1; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            // 老末
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[dp.length - 1][0];
        for (int i = 0; i < dp[dp.length - 1].length; ++i) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        return min;
    }

}
