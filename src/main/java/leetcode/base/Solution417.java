package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
public class Solution417 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < n; ++i) {
            dfs(heights, pacific, 0, i);
            dfs(heights, atlantic, m - 1, i);
        }
        for (int i = 0; i < m; ++i) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int x, int y) {
        if (ocean[x][y]) {
            return;
        }
        ocean[x][y] = true;
        for (int i = 0; i < direction.length; ++i) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || heights[nx][ny] < heights[x][y]) {
                continue;
            }
            dfs(heights, ocean, nx, ny);
        }
    }

}
