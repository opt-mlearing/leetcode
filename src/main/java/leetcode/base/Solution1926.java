package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1926. 迷宫中离入口最近的出口
 * https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/
 *
 * @author: caogl
 * @date: 2022/7/19, 1:17
 **/
public class Solution1926 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Deque<int[]> stack = new LinkedList<int[]>();
        stack.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int res = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; ++i) {
                int[] item = stack.poll();
                int x = item[0];
                int y = item[1];
                for (int j = 0; j < direction.length; ++j) {
                    int nx = x + direction[j][0];
                    int ny = y + direction[j][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == '.') {
                        if (nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1) {
                            // 到达边界就结束.
                            return res + 1;
                        }
                        maze[nx][ny] = '+';
                        stack.offer(new int[]{nx, ny});
                    }
                }
            }
            res++;
        }
        return -1;
    }

}
