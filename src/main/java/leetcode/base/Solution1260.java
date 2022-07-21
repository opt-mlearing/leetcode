package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * https://leetcode.cn/problems/shift-2d-grid/
 *
 * @author: caogl
 * @date: 2022/7/22, 0:31
 **/
public class Solution1260 {

    // 4ms/41.8MB
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int[] position = location(m, n, k, i, j);
                tmp[position[0]][position[1]] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < n; ++j) {
                sub.add(tmp[i][j]);
            }
            res.add(sub);
        }
        return res;
    }

    private int[] location(int m, int n, int k, int x, int y) {
        int tmp = (x * n + y + k) % (m * n);
        return new int[]{tmp / n, tmp % n};
    }

}
