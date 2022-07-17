package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * https://leetcode.cn/problems/pacific-atlantic-water-flow/
 *
 * @author: caogl
 * @date: 2022/7/17, 23:03
 **/
public class Solution417 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    // bfs
    // 9ms/42.4mb
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // 0 pacific/ 1 atlantic
        boolean[][][] ocean = new boolean[m][n][2];
        for (int i = 0; i < m; ++i) {
            bfs(m, n, heights, ocean, i, 0, 0);
            bfs(m, n, heights, ocean, i, n - 1, 1);
        }
        for (int i = 0; i < n; ++i) {
            bfs(m, n, heights, ocean, 0, i, 0);
            bfs(m, n, heights, ocean, m - 1, i, 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (ocean[i][j][0] && ocean[i][j][1]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(int m, int n, int[][] heights, boolean[][][] ocean, int row, int col, int oceanIndex) {
        if (ocean[row][col][oceanIndex]) {
            return;
        }
        Deque<int[]> stack = new LinkedList<int[]>();
        ocean[row][col][oceanIndex] = true;
        stack.offer(new int[]{row, col});
        while (!stack.isEmpty()) {
            int[] item = stack.poll();
            int x = item[0];
            int y = item[1];
            for (int i = 0; i < direction.length; ++i) {
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !ocean[nx][ny][oceanIndex] && heights[x][y] <= heights[nx][ny]) {
                    ocean[nx][ny][oceanIndex] = true;
                    stack.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // dfs
    // 8ms/ 42.5mb
    public List<List<Integer>> pacificAtlantic_dfs(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // 0 pacific/ 1 atlantic
        boolean[][][] ocean = new boolean[m][n][2];
        for (int i = 0; i < m; ++i) {
            dfs(m, n, heights, ocean, i, 0, 0);
            dfs(m, n, heights, ocean, i, n - 1, 1);
        }
        for (int i = 0; i < n; ++i) {
            dfs(m, n, heights, ocean, 0, i, 0);
            dfs(m, n, heights, ocean, m - 1, i, 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (ocean[i][j][0] && ocean[i][j][1]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int m, int n, int[][] heights, boolean[][][] ocean, int x, int y, int oceanIndex) {
        if (ocean[x][y][oceanIndex]) {
            return;
        }
        ocean[x][y][oceanIndex] = true;
        for (int i = 0; i < direction.length; ++i) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !ocean[nx][ny][oceanIndex] && heights[x][y] <= heights[nx][ny]) {
                dfs(m, n, heights, ocean, nx, ny, oceanIndex);
            }
        }
    }

    private int m;
    private int n;

    // dfs
    // 4ms/42.8mb
    public List<List<Integer>> pacificAtlantic_dfs1_1(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < n; ++i) {
            dfs_1(heights, pacific, 0, i);
            dfs_1(heights, atlantic, m - 1, i);
        }
        for (int i = 0; i < m; ++i) {
            dfs_1(heights, pacific, i, 0);
            dfs_1(heights, atlantic, i, n - 1);
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

    private void dfs_1(int[][] heights, boolean[][] ocean, int x, int y) {
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
            dfs_1(heights, ocean, nx, ny);
        }
    }

}
