package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1254. 统计封闭岛屿的数目
 * https://leetcode.cn/problems/number-of-closed-islands/
 *
 * @author: caogl
 * @date: 2022/7/15, 1:27
 **/
public class Solution1254 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    // bfs
    // 5ms/ 41.2mb
    public int closedIsland_bfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisit = new boolean[m][n];
        // 先处理边界，边界为土地的不能围成封闭岛屿.
        Deque<int[]> stack = new LinkedList<int[]>();
        for (int i = 0; i < m; ++i) {
            isVisit[i][0] = true;
            isVisit[i][n - 1] = true;
            if (grid[i][0] == 0) {
                stack.offer(new int[]{i, 0});
            }
            if (grid[i][n - 1] == 0) {
                stack.offer(new int[]{i, n - 1});
            }
        }
        for (int i = 1; i < n - 1; ++i) {
            isVisit[0][i] = true;
            isVisit[m - 1][i] = true;
            if (grid[0][i] == 0) {
                stack.offer(new int[]{0, i});
            }
            if (grid[m - 1][i] == 0) {
                stack.offer(new int[]{m - 1, i});
            }
        }
        while (!stack.isEmpty()) {
            int[] item = stack.poll();
            grid[item[0]][item[1]] = 1;
            for (int i = 0; i < direction.length; ++i) {
                int nx = item[0] + direction[i][0];
                int ny = item[1] + direction[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !isVisit[nx][ny] && grid[nx][ny] == 0) {
                    isVisit[nx][ny] = true;
                    stack.offer(new int[]{nx, ny});
                }
            }
        }
        int res = 0;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                // 从一块陆地开始递归搜索.
                stack.clear();
                if (grid[i][j] == 0 && !isVisit[i][j]) {
                    isVisit[i][j] = true;
                    stack.offer(new int[]{i, j});
                    while (!stack.isEmpty()) {
                        int[] item = stack.poll();
                        grid[item[0]][item[1]] = 1;
                        for (int k = 0; k < direction.length; ++k) {
                            int nx = item[0] + direction[k][0];
                            int ny = item[1] + direction[k][1];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !isVisit[nx][ny] && grid[nx][ny] == 0) {
                                isVisit[nx][ny] = true;
                                stack.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }

    // dfs
    // 1ms/42.2mb
    public int closedIsland_dfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 先搜素边界
        for (int i = 0; i < m; ++i) {
            dfs(grid, m, n, i, 0);
            dfs(grid, m, n, i, n - 1);
        }
        for (int i = 1; i < n - 1; ++i) {
            dfs(grid, m, n, 0, i);
            dfs(grid, m, n, m - 1, i);
        }
        // 与飞岛问题类似，这里需要针对封闭的岛屿再递归搜索一下.
        int res = 0;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                // 从一块陆地开始递归搜索.
                if (grid[i][j] == 0) {
                    dfs(grid, m, n, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        dfs(grid, m, n, i, j - 1);
        dfs(grid, m, n, i, j + 1);
        dfs(grid, m, n, i - 1, j);
        dfs(grid, m, n, i + 1, j);
    }

}
