package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1091. 二进制矩阵中的最短路径
 * https://leetcode.cn/problems/shortest-path-in-binary-matrix/
 *
 * @author: caogl
 * @date: 2022/7/18, 0:43
 **/
public class Solution1091 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    // bfs
    // 15ms/42.4mb
    public int shortestPathBinaryMatrix_bfs(int[][] grid) {
        int n = grid.length;
        Deque<int[]> stack = new LinkedList<int[]>();
        if (grid[0][0] != 0) {
            return -1;
        }
        stack.offer(new int[]{0, 0});
        boolean[][] isVisit = new boolean[n][n];
        isVisit[0][0] = true;
        int res = 1;
        while (!stack.isEmpty()) {
            if (isVisit[n - 1][n - 1]) {
                return res;
            }
            int size = stack.size();
            for (int i = 0; i < size; ++i) {
                int[] item = stack.poll();
                int x = item[0];
                int y = item[1];
                for (int j = 0; j < direction.length; ++j) {
                    int nx = x + direction[j][0];
                    int ny = y + direction[j][1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0 && !isVisit[nx][ny]) {
                        isVisit[nx][ny] = true;
                        stack.offer(new int[]{nx, ny});
                    }
                }
            }
            res++;
        }
        return -1;
    }

}
