package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 695. 岛屿的最大面积
 * https://leetcode.cn/problems/max-area-of-island/
 *
 * @author: caogl
 * @date: 2022/7/14, 23:56
 **/
public class Solution695 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    // bfs
    // 3ms/41.7mb
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisit = new boolean[m][n];
        Deque<int[]> stack = new LinkedList<int[]>();
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !isVisit[i][j]) {
                    isVisit[i][j] = true;
                    stack.offer(new int[]{i, j});
                    int area = 0;
                    while (!stack.isEmpty()) {
                        int[] item = stack.poll();
                        area++;
                        grid[item[0]][item[1]] = 0;
                        for (int k = 0; k < direction.length; ++k) {
                            int x = item[0] + direction[k][0];
                            int y = item[1] + direction[k][1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !isVisit[x][y]) {
                                isVisit[x][y] = true;
                                stack.offer(new int[]{x, y});
                            }
                        }
                    }
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    // dfs
    // 1ms/41.6mb
    public int maxAreaOfIsland_dfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, m, n, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int m, int n, int x, int y) {
        int area = 1;
        grid[x][y] = 0;
        for (int i = 0; i < direction.length; ++i) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                area += dfs(grid, m, n, nx, ny);
            }
        }
        return area;
    }

    // 通过深度搜索的方式遍历整个 m* n 矩阵.
    // 1ms/41.5mb
    public int maxAreaOfIsland_dfs_1(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 这里可以多增加一个判断，从陆地开始递归搜索.
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs_1(grid, i, j, m, n));
                }
            }
        }
        return maxArea;
    }

    // 深度搜索方式.
    private int dfs_1(int[][] grid, int row, int column, int m, int n) {
        // grid[row][columnMax]==1 表示暂未被搜索过区域.
        if (row < 0 || row >= m || column < 0 || column >= n || grid[row][column] != 1) {
            return 0;
        }
        // 标记已经搜索过.
        grid[row][column] = 0;
        int area = 1;
        area += dfs_1(grid, row - 1, column, m, n);
        area += dfs_1(grid, row + 1, column, m, n);
        area += dfs_1(grid, row, column - 1, m, n);
        area += dfs_1(grid, row, column + 1, m, n);
        return area;
    }

}
