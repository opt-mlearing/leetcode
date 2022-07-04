package leetcode.base;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        Solution1034 solution = new Solution1034();
        int[][] grid = {{1, 1}, {1, 2}};
        int[][] arrays = solution.colorBorder(grid, 0, 0, 3);
        for (int i = 0; i < arrays.length; ++i) {
            System.out.println(Arrays.toString(arrays[i]));
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        list = new ArrayList<int[]>();
        boolean[][] isVisit = new boolean[m][n];
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
