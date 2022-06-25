package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * https://leetcode.cn/problems/pascals-triangle-ii/
 *
 * @author: caogl
 * @date: 2022/6/25, 23:39
 **/
public class Solution119 {

    // dp.
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; ++i) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        for (int i = 0; i <= rowIndex; ++i) {
            for (int j = 1; j < i; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        for (int i = 0; i <= rowIndex; ++i) {
            res.add(dp[rowIndex][i]);
        }
        return res;
    }

    // 先生成杨辉三角，再返回最后一样就好.
    public List<Integer> getRow_traverse(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    List<Integer> row = res.get(i - 1);
                    tmp.add(row.get(j - 1) + row.get(j));
                }
            }
            res.add(tmp);
        }
        return res.get(rowIndex);
    }

}
