package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1905. 统计子岛屿
 * https://leetcode.cn/problems/count-sub-islands/
 *
 * @author: caogl
 * @date: 2022/7/17, 16:04
 **/
public class Solution1905 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        boolean[][] isVisit = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1 && !isVisit[i][j]) {
                    if (bfs(grid1, grid2, isVisit, m, n, i, j)) {
                        isVisit[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean bfs(int[][] grid1, int[][] grid2, boolean[][] isVisit, int m, int n, int x, int y) {
        Deque<int[]> stack = new LinkedList<int[]>();
        stack.offer(new int[]{x, y});
        boolean flag = true;
        while (!stack.isEmpty()) {
            int[] item = stack.poll();
            int row = item[0];
            int col = item[1];
            grid2[row][col] = 0;
            flag &= (grid1[row][col] == 1);
            for (int i = 0; i < direction.length; ++i) {
                int nrow = row + direction[i][0];
                int ncol = col + direction[i][1];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid2[nrow][ncol] == 1 && !isVisit[nrow][ncol]) {
                    isVisit[nrow][ncol] = true;
                    flag &= (grid1[nrow][ncol] == 1);
                    stack.offer(new int[]{nrow, ncol});
                }
            }
        }
        return flag;
    }

}
