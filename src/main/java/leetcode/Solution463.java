package leetcode;

/**
 * 岛屿的周长.
 * https://leetcode-cn.com/problems/island-perimeter/
 */
public class Solution463 {

    // 注意，这里有一个小小的特性，1）当从陆地走到水里面时，周长+ 1； 2）从陆地走出二维网格的边界时，周长+ 1；
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    count += dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    // 1 表示没有被搜索过的陆地
    // 2 表示已经被搜索过的陆地
    private int dfs(int row, int column, int[][] grid) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0) {
            return 1;
        }
        if (grid[row][column] != 1) {
            return 0;
        }
        grid[row][column] = 2;
        int len = 0;
        len += dfs(row - 1, column, grid);
        len += dfs(row + 1, column, grid);
        len += dfs(row, column - 1, grid);
        len += dfs(row, column + 1, grid);
        return len;
    }

}
