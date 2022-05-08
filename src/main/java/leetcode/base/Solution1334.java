package leetcode.base;

import java.util.Arrays;

/**
 * 1334. 阈值距离内邻居最少的城市
 * https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class Solution1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE / 2);
            matrix[i][i] = 0;
        }
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }
        floyed(matrix, n);
        int res = -1;
        int minNum = n + 1;
        // 选择出到达其它城市最少的城市.
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (i != j && matrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minNum) {
                minNum = count;
                res = i;
            }
        }
        return res;
    }

    // floyed.
    private void floyed(int[][] matrix, int n) {
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }

}
