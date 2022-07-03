package leetcode.base;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 542. 01 矩阵
 * https://leetcode-cn.com/problems/01-matrix/
 *
 * @author: caogl
 * @date: 2022/7/4, 1:12
 **/
public class Solution542 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length];
        boolean[][] visit = new boolean[mat.length][mat[0].length];
        // 先找到全部超级零
        Deque<int[]> deque = new ArrayDeque<int[]>();
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                if (mat[i][j] == 0) {
                    deque.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        // 从超级零出发
        while (!deque.isEmpty()) {
            int[] tmp = deque.pop();
            int x = tmp[0];
            int y = tmp[1];
            for (int i = 0; i < direction.length; ++i) {
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];
                if (nx < 0 || nx >= mat.length || ny < 0 || ny >= mat[0].length || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                distance[nx][ny] = distance[x][y] + 1;
                // 新增的全部在队列尾部，不需要分层.
                deque.offer(new int[]{nx, ny});
            }
        }
        return distance;
    }

    // 深度搜索存在性能问题，存在重复搜索.
    public int[][] updateMatrix_dfs(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length];
        boolean[][] visit = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                distance[i][j] = dfs(mat, visit, i, j);
            }
        }
        return distance;
    }

    private int dfs(int[][] mat, boolean[][] visit, int i, int j) {
        if (mat[i][j] == 0) {
            return 0;
        }
        int tmp = 4;
        visit[i][j] = true;
        for (int k = 0; k < direction.length; ++k) {
            int m = i + direction[k][0];
            int n = j + direction[k][1];
            if (m < 0 || m >= mat.length || n < 0 || n >= mat[0].length || visit[m][n]) {
                continue;
            }
            tmp = Math.min(tmp, 1 + dfs(mat, visit, m, n));
        }
        visit[i][j] = false;
        return tmp;
    }

}
