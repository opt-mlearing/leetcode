package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1020. 飞地的数量
 * https://leetcode.cn/problems/number-of-enclaves/
 *
 * @author: caogl
 * @date: 2022/7/15, 2:26
 **/
public class Solution1020 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    // bfs
    // 11ms/48.8mb
    public int numEnclaves_bfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 清空边界.
        Deque<int[]> stack = new LinkedList<int[]>();
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 1) {
                grid[i][0] = 0;
                stack.offer(new int[]{i, 0});
            }
            if (grid[i][n - 1] == 1) {
                grid[i][n - 1] = 0;
                stack.offer(new int[]{i, n - 1});
            }
        }
        for (int i = 1; i < n - 1; ++i) {
            if (grid[0][i] == 1) {
                grid[0][i] = 0;
                stack.offer(new int[]{0, i});
            }
            if (grid[m - 1][i] == 1) {
                grid[m - 1][i] = 0;
                stack.offer(new int[]{m - 1, i});
            }
        }
        while (!stack.isEmpty()) {
            int[] item = stack.poll();
            for (int i = 0; i < direction.length; ++i) {
                int nx = item[0] + direction[i][0];
                int ny = item[1] + direction[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                    grid[nx][ny] = 0;
                    stack.offer(new int[]{nx, ny});
                }
            }
        }
        // 统计飞地的数量.
        stack.clear();
        int res = 0;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    stack.offer(new int[]{i, j});
                    while (!stack.isEmpty()) {
                        int[] item = stack.poll();
                        res++;
                        for (int k = 0; k < direction.length; ++k) {
                            int nx = item[0] + direction[k][0];
                            int ny = item[1] + direction[k][1];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                                grid[nx][ny] = 0;
                                stack.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    // dfs
    // 8ms/ 49.7mb
    public int numEnclaves_dfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 处理边界上的海洋.
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 1) {
                dfs(grid, m, n, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                dfs(grid, m, n, i, n - 1);
            }
        }
        for (int i = 1; i < n - 1; ++i) {
            if (grid[0][i] == 1) {
                dfs(grid, m, n, 0, i);
            }
            if (grid[m - 1][i] == 1) {
                dfs(grid, m, n, m - 1, i);
            }
        }
        // 寻找飞地
        int res = 0;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (grid[i][j] == 1) {
                    res += dfs(grid, m, n, i, j);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int m, int n, int x, int y) {
        grid[x][y] = 0;
        int res = 1;
        for (int i = 0; i < direction.length; ++i) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                res += dfs(grid, m, n, nx, ny);
            }
        }
        return res;
    }

    private int m;
    private int n;
    private boolean[][] isVisit;

    // dfs
    // 4ms/48.7mb
    public int numEnclaves_1(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isVisit = new boolean[m][n];
        // 从边框开始搜索.
        for (int i = 0; i < m; ++i) {
            dfs_1(grid, i, 0);
            dfs_1(grid, i, n - 1);
        }
        for (int i = 1; i < n - 1; ++i) {
            dfs_1(grid, 0, i);
            dfs_1(grid, m - 1, i);
        }
        // 统计不包含边框的岛屿数量.
        int res = 0;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (!isVisit[i][j] && grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }

    private void dfs_1(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || isVisit[i][j]) {
            return;
        }
        isVisit[i][j] = true;
        dfs_1(grid, i - 1, j);
        dfs_1(grid, i + 1, j);
        dfs_1(grid, i, j - 1);
        dfs_1(grid, i, j + 1);
    }

}
