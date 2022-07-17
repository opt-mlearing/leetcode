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

    // 多源头bfs
    // 14ms/ 42.7mb
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        Deque<int[]> stack = new LinkedList<int[]>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    stack.offer(new int[]{i, j});
                }
            }
        }
        while (!stack.isEmpty()) {
            int[] item = stack.poll();
            for (int i = 0; i < direction.length; ++i) {
                int nx = item[0] + direction[i][0];
                int ny = item[1] + direction[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && dp[nx][ny] > dp[item[0]][item[1]] + 1) {
                    dp[nx][ny] = dp[item[0]][item[1]] + 1;
                    stack.offer(new int[]{nx, ny});
                }
            }
        }
        int res = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                // 寻找水的地方.
                if (grid[i][j] == 0) {
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }

    // dp
    // 7ms/ 42.7mb
    public int maxDistance_dp(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                // 最大值不能设置成Integer.MAX_VALUE, 需要/2, 若否则正好+1溢出.
                dp[i][j] = (grid[i][j] == 1 ? 0 : Integer.MAX_VALUE / 2);
            }
        }
        // 第一个阶段，从左上到右下.
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 第二个阶段，从右下到左上.
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        int res = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                // 寻找水的地方.
                if (grid[i][j] == 0) {
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }

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
