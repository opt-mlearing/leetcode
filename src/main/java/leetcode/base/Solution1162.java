package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1162. 地图分析
 * https://leetcode.cn/problems/as-far-from-land-as-possible/
 *
 * @author: caogl
 * @date: 2022/7/17, 16:01
 **/
public class Solution1162 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    // bfs, 部分case可以获取正确答案，全量case会运行失败，超出时间限制.
    public int maxDistance_dfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = -1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    int tmp = bfs(grid, m, n, i, j);
                    res = Math.max(res, tmp);
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int m, int n, int x, int y) {
        boolean[][] isVisit = new boolean[m][n];
        Deque<int[]> stack = new LinkedList<int[]>();
        stack.offer(new int[]{x, y});
        isVisit[x][y] = true;
        int res = 0;
        while (!stack.isEmpty()) {
            int len = stack.size();
            res++;
            for (int i = 0; i < len; ++i) {
                int[] item = stack.poll();
                for (int j = 0; j < direction.length; ++j) {
                    int nx = item[0] + direction[j][0];
                    int ny = item[1] + direction[j][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !isVisit[nx][ny]) {
                        if (grid[nx][ny] == 1) {
                            return res;
                        } else {
                            isVisit[nx][ny] = true;
                            stack.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }

}
