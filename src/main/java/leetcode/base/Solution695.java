package leetcode.base;

/**
 * 岛屿的最大面积.
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class Solution695 {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                maxArea = Math.max(maxArea, dfs(i, j, grid));
            }
        }
        return maxArea;
    }

    private int dfs(int row, int column, int[][] grid) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] != 1) {
            return 0;
        }
        grid[row][column] = 2;
        int area = 1;
        area += dfs(row - 1, column, grid);
        area += dfs(row + 1, column, grid);
        area += dfs(row, column - 1, grid);
        area += dfs(row, column + 1, grid);
        return area;
    }

}
