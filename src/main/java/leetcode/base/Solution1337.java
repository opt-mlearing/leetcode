package leetcode.base;

import java.util.PriorityQueue;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * https://leetcode.cn/problems/the-k-weakest-rows-in-a-matrix/
 */
public class Solution1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(k, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; ++i) {
            int left = 0;
            int right = n - 1;
            int pos = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mat[i][mid] == 1) {
                    pos = mid;
                    left = mid + 1;
                } else if (mat[i][mid] == 0) {
                    right = mid - 1;
                }
            }
            priorityQueue.offer(new int[]{pos + 1, i});
        }
        int[] res = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty() && k > 0) {
            res[index++] = priorityQueue.poll()[1];
            k--;
        }
        return res;
    }

}
