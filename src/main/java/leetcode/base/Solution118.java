package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode.cn/problems/pascals-triangle/
 *
 * @author: caogl
 * @date: 2022/6/25, 23:31
 **/
public class Solution118 {

    // dp网格.
    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; ++i) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j > 0 && j <= i - 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
                sub.add(dp[i][j]);
            }
            res.add(sub);
        }
        return res;
    }

    // 依次遍历.
    public List<List<Integer>> generate_traverse(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> subList = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                // 每行的第一个和最后一个
                if (j == 0 || j == i) {
                    subList.add(1);
                } else {
                    List<Integer> preList = res.get(i - 1);
                    subList.add(preList.get(j - 1) + preList.get(j));
                }
            }
            res.add(subList);
        }
        return res;
    }

}
