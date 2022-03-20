package leetcode;

import java.util.List;

/**
 * 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 */
public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
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
