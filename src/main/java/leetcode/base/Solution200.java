package leetcode.base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 200. 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/
 *
 * @author: caogl
 * @date: 2022/7/13, 23:27
 **/
public class Solution200 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    // bfs
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisit = new boolean[m][n];
        Deque<int[]> stack = new LinkedList<int[]>();
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && !isVisit[i][j]) {
                    isVisit[i][j] = true;
                    res++;
                    stack.offer(new int[]{i, j});
                    while (!stack.isEmpty()) {
                        int[] item = stack.poll();
                        grid[item[0]][item[1]] = '0';
                        for (int k = 0; k < direction.length; ++k) {
                            int ni = item[0] + direction[k][0];
                            int nj = item[1] + direction[k][1];
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == '1' && !isVisit[ni][nj]) {
                                isVisit[ni][nj] = true;
                                stack.offer(new int[]{ni, nj});
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    // dfs
    public int numIslands_dfs(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, m, n, i, j);
                }
            }
        }
        return res;
    }

    // dfs把上下左右四个方向上相邻的‘1’全部变成‘0’.
    private void dfs(char[][] grid, int m, int n, int row, int column) {
        grid[row][column] = '0';
        for (int i = 0; i < direction.length; ++i) {
            int nrow = row + direction[i][0];
            int ncolumn = column + direction[i][1];
            if (nrow >= 0 && nrow < m && ncolumn >= 0 && ncolumn < n && grid[nrow][ncolumn] == '1') {
                dfs(grid, m, n, nrow, ncolumn);
            }
        }
    }

    // 宽度优先搜索.
    public int numIslands_bfs_1(char[][] grid) {
        int rowLen = grid.length;
        int columnLen = grid[0].length;
        int landSize = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < columnLen; ++j) {
                if (grid[i][j] == '1') {
                    landSize++;
                    // 发现陆地，然后以此为起点进行搜索，并把与当前陆地相连陆地全部变成水，进而避免了重复搜索.
                    int value = i * columnLen + j;
                    deque.offer(value);
                    while (!deque.isEmpty()) {
                        Integer tmp = deque.pop();
                        int row = tmp / columnLen;
                        int column = tmp % columnLen;
                        if (grid[row][column] == '0') {
                            continue;
                        }
                        grid[row][column] = '0';
                        // 提前逐个判断，需要保证基于当前位置递归搜索的下一个位置一定是有效的.
                        if (row - 1 >= 0) {
                            deque.offer((row - 1) * columnLen + column);
                        }
                        if (row + 1 < rowLen) {
                            deque.offer((row + 1) * columnLen + column);
                        }
                        if (column - 1 >= 0) {
                            deque.offer(row * columnLen + (column - 1));
                        }
                        if (column + 1 < columnLen) {
                            deque.offer(row * columnLen + (column + 1));
                        }
                    }
                }
            }
        }
        return landSize;
    }

    // 深度优先搜索.
    public int numIslands_dfs_1(char[][] grid) {
        int rowLen = grid.length;
        if (rowLen == 0) {
            return 0;
        }
        int columnLen = grid[0].length;
        int landCount = 0;
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < columnLen; ++j) {
                if (grid[i][j] == '1') {
                    landCount = landCount + 1;
                    // 只要发现陆地，就使用深度搜索将陆地变成水.
                    dfs_1(grid, i, j, rowLen, columnLen);
                }
            }
        }
        return landCount;
    }

    private void dfs_1(char[][] grid, int row, int column, final int rowLen, final int columnLen) {
        if (row < 0 || row >= rowLen || column < 0 || column >= columnLen || grid[row][column] == '0') {
            return;
        }
        // 把陆地变成水
        grid[row][column] = '0';
        dfs_1(grid, row - 1, column, rowLen, columnLen);
        dfs_1(grid, row + 1, column, rowLen, columnLen);
        dfs_1(grid, row, column - 1, rowLen, columnLen);
        dfs_1(grid, row, column + 1, rowLen, columnLen);
    }

}
