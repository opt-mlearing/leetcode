package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 934. 最短的桥
 * https://leetcode.cn/problems/shortest-bridge/
 *
 * @author: caogl
 * @date: 2022/7/6, 2:22
 **/
public class Solution934 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisit = new boolean[m][n];
        boolean isFirst = true;
        Deque<int[]> stack1 = new LinkedList<int[]>();
        Deque<int[]> stack2 = new LinkedList<int[]>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!isVisit[i][j] && grid[i][j] == 1) {
                    if (isFirst) {
                        dfs(grid, i, j, m, n, isVisit, true, stack1);
                        isFirst = false;
                    } else {
                        dfs(grid, i, j, m, n, isVisit, false, stack2);
                    }
                }
            }
        }
        if (stack1.size() > stack2.size()) {
            stack1 = new LinkedList<int[]>(stack2);
        }
        stack2.clear();
        isVisit = new boolean[m][n];
        while (!stack1.isEmpty()) {
            int[] item = stack1.poll();
            isVisit[item[0]][item[1]] = true;
            stack2.offer(new int[]{item[0], item[1]});
        }
        stack1 = stack2;
        int res = 0;
        if (stack1.isEmpty()) {
            return res;
        }
        int[] tmp = stack1.peek();
        int target = 3 - grid[tmp[0]][tmp[1]];
        while (!stack1.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; ++i) {
                int[] item = stack1.poll();
                for (int j = 0; j < direction.length; ++j) {
                    int row = item[0] + direction[j][0];
                    int col = item[1] + direction[j][1];
                    if (row >= 0 && row < m && col >= 0 && col < n && !isVisit[row][col]) {
                        if (grid[row][col] == target) {
                            return res;
                        }
                        isVisit[row][col] = true;
                        stack1.offer(new int[]{row, col});
                    }
                }
            }
            res++;
        }
        return res;
    }

    private void dfs(int[][] grid, int row, int col, int m, int n,
                     boolean[][] isVisit, boolean isFirst, Deque<int[]> stack) {
        if (isFirst) {
            grid[row][col] = 2;
        }
        stack.offer(new int[]{row, col});
        for (int i = 0; i < direction.length; ++i) {
            int nrow = row + direction[i][0];
            int ncol = col + direction[i][1];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1 && !isVisit[nrow][ncol]) {
                isVisit[nrow][ncol] = true;
                dfs(grid, nrow, ncol, m, n, isVisit, isFirst, stack);
            }
        }
    }

}
