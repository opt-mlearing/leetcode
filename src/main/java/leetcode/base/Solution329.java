package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 329. 矩阵中的最长递增路径
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 */
public class Solution329 {

    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] maxLenMatrix;
    private int maxLen;

    // 拓扑排序方法.
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] degree = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int[] dir : direction) {
                    int iNew = i + dir[0];
                    int jNew = j + dir[1];
                    if (iNew >= 0 && iNew < m && jNew >= 0 && jNew < n && matrix[i][j] < matrix[iNew][jNew]) {
                        degree[i][j]++;
                    }
                }
            }
        }
        // 缓存入度为0的位置.也就最大数的坐标.
        Deque<int[]> deque = new LinkedList<int[]>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (degree[i][j] == 0) {
                    deque.offer(new int[]{i, j});
                }
            }
        }
        int res = 0;
        while (!deque.isEmpty()) {
            // 一次性出栈一堆出度为0的开始坐标.
            // 也就是最大位置的坐标.
            res++;
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                int[] item = deque.poll();
                int x = item[0];
                int y = item[1];
                // 朝四个可能的方向移动.
                for (int[] dir : direction) {
                    int xN = x + dir[0];
                    int yN = y + dir[1];
                    if (xN >= 0 && xN < m && yN >= 0 && yN < n && matrix[x][y] > matrix[xN][yN]) {
                        degree[xN][yN]--;
                        if (degree[xN][yN] == 0) {
                            deque.offer(new int[]{xN, yN});
                        }
                    }
                }
            }
        }
        return res;
    }

    // 带记忆的深度递归.
    public int longestIncreasingPath_dfs(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        maxLenMatrix = new int[m][n];
        maxLen = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 任意元素最短递增路径长度是1,
                // maxLenMatrix[i][j]标记当前位置未被搜索过.
                if (maxLenMatrix[i][j] == 0) {
                    doLongestIncreasingPath(matrix, i, j, m, n);
                }
            }
        }
        return maxLen;
    }

    // 深度递归搜索.
    private int doLongestIncreasingPath(int[][] matrix, int i, int j, int m, int n) {
        if (maxLenMatrix[i][j] != 0) {
            return maxLenMatrix[i][j];
        }
        maxLenMatrix[i][j] = 1;
        for (int k = 0; k < direction.length; ++k) {
            int i1 = i + direction[k][0];
            int j1 = j + direction[k][1];
            // matrix[i][j] 表示从[i][j] 开始最长递增序列长度.
            if (i1 >= 0 && i1 < m && j1 >= 0 && j1 < n && matrix[i][j] > matrix[i1][j1]) {
                maxLenMatrix[i][j] =
                        Math.max(maxLenMatrix[i][j], doLongestIncreasingPath(matrix, i1, j1, m, n) + 1);
            }
        }
        maxLen = Math.max(maxLen, maxLenMatrix[i][j]);
        return maxLenMatrix[i][j];
    }

}
