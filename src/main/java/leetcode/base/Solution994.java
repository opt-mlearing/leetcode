package leetcode.base;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 腐烂的橘子
 * https://leetcode-cn.com/problems/rotting-oranges/
 */
public class Solution994 {

    private static final int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        // 找到全部腐烂的橘子
        Deque<int[]> deque = new ArrayDeque<int[]>();
        int isFresh = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    ++isFresh;
                }
            }
        }
        int minute = 0;
        while (!deque.isEmpty()) {
            int[] tmp = deque.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int i = 0; i < direction.length; ++i) {
                int nX = x + direction[i][0];
                int nY = y + direction[i][1];
                while (nX >= 0 && nX < grid.length && nY >= 0 && nY < grid[0].length && grid[nX][nY] == 1) {
                    --isFresh;
                    // 把好橘子变成烂橘子
                    grid[nX][nY] = 2;
                    distance[nX][nY] = distance[x][y] + 1;
                    minute = Math.max(minute, distance[nX][nY]);
                    deque.offer(new int[]{nX, nY});
                }
            }
        }
        return isFresh == 0 ? minute : -1;
    }

}
