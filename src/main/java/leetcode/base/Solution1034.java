package leetcode.base;


import java.util.*;

/**
 * 1034. 边界着色
 * https://leetcode.cn/problems/coloring-a-border/submissions/
 *
 * @author caogaoli
 * @date 2022/7/4 11:19
 */
public class Solution1034 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private List<int[]> list;
    private Deque<int[]> stack;

    // bfs
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        stack = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisit = new boolean[m][n];
        stack.offer(new int[]{row, col});
        isVisit[row][col] = true;
        List<int[]> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            int[] top = stack.poll();
            boolean isBorder = false;
            for (int i = 0; i < direction.length; ++i) {
                int nrow = top[0] + direction[i][0];
                int ncol = top[1] + direction[i][1];
                if (!(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[top[0]][top[1]] == grid[nrow][ncol])) {
                    isBorder = true;
                } else if (!isVisit[nrow][ncol]) {
                    isVisit[nrow][ncol] = true;
                    stack.offer(new int[]{nrow, ncol});
                }
            }
            if (isBorder) {
                list.add(new int[]{top[0], top[1]});
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            int[] item = list.get(i);
            grid[item[0]][item[1]] = color;
        }
        return grid;
    }

    // dfs
    public int[][] colorBorder_dfs(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        list = new ArrayList<int[]>();
        boolean[][] isVisit = new boolean[m][n];
        isVisit[row][col] = true;
        dfs(grid, row, col, m, n, isVisit);
        for (int i = 0; i < list.size(); ++i) {
            int[] item = list.get(i);
            grid[item[0]][item[1]] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int m, int n, boolean[][] isVisit) {
        boolean isBorder = false;
        for (int i = 0; i < direction.length; ++i) {
            int nrow = row + direction[i][0];
            int ncol = col + direction[i][1];
            // 判断是不是边界.
            if (!(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[row][col] == grid[nrow][ncol])) {
                isBorder = true;
            } else if (!isVisit[nrow][ncol]) {
                isVisit[nrow][ncol] = true;
                dfs(grid, nrow, ncol, m, n, isVisit);
            }
        }
        if (isBorder) {
            list.add(new int[]{row, col});
        }
    }

}
