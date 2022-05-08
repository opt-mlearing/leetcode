package leetcode.base;

import java.util.Arrays;

/**
 * 743. 网络延迟时间
 * https://leetcode-cn.com/problems/network-delay-time/
 */
public class Solution743 {

    // dijkstra，不能处理负权的情况.
    // 2ms/ 44.1mb
    // https://www.bilibili.com/video/BV1RK4y1d7ct?p=2&spm_id_from=pageDriver .
    public int networkDelayTime_dijkstra(int[][] times, int n, int k) {
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE / 2);
            matrix[i][i] = 0;
        }
        for (int i = 0; i < times.length; ++i) {
            matrix[times[i][0]][times[i][1]] = times[i][2];
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE / 2);
        distance[k] = 0;
        boolean[] isVisit = new boolean[n + 1];
        Arrays.fill(isVisit, true);
        for (int i = 1; i <= n; ++i) {
            // 找到最短距离.
            int minIndex = -1;
            for (int j = 1; j <= n; ++j) {
                if ((isVisit[j]) && (minIndex == -1 || distance[minIndex] > distance[j])) {
                    minIndex = j;
                }
            }
            // 如果找不到，就退出.
            if (minIndex == -1) {
                break;
            }
            isVisit[minIndex] = false;
            for (int j = 1; j <= n; ++j) {
                if (isVisit[j]) {
                    distance[j] = Math.min(distance[j], distance[minIndex] + matrix[minIndex][j]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; ++i) {
            res = Math.max(res, distance[i]);
        }
        return (res == Integer.MAX_VALUE / 2) ? -1 : res;
    }

    // floyed最短路径，floyed可以处理负权，但是不能处理负环.
    // floyed字资料，"https://www.bilibili.com/video/BV1RK4y1d7ct?p=1".
    // 11ms/ 44mb.
    public int networkDelayTime_floyed(int[][] times, int n, int k) {
        int[][] values = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(values[i], Integer.MAX_VALUE / 2);
            // 自己到自己等于0.
            values[i][i] = 0;
        }
        for (int i = 0; i < times.length; ++i) {
            int[] time = times[i];
            values[time[0]][time[1]] = time[2];
        }
        for (int m = 1; m <= n; ++m) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    // 注意最大值不能设置成 Integer.MAX_VALUE, 要么两个最大相加就越界.
                    if (values[i][j] > values[i][m] + values[m][j]) {
                        values[i][j] = values[i][m] + values[m][j];
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; ++i) {
            res = Math.max(res, values[k][i]);
        }
        return res == (Integer.MAX_VALUE / 2) ? -1 : res;
    }

}
