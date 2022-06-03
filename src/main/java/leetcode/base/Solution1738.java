package leetcode.base;

import java.util.PriorityQueue;

/**
 * 1738. 找出第 K 大的异或坐标值
 * https://leetcode.cn/problems/find-kth-largest-xor-coordinate-value/
 */
public class Solution1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((item1, item2) -> item2 - item1);
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                preSum[i][j] = preSum[i - 1][j - 1] ^ preSum[i][j - 1] ^ preSum[i - 1][j] ^ matrix[i - 1][j - 1];
                queue.offer(preSum[i][j]);
            }
        }
        for (int i = 1; i < k && !queue.isEmpty(); ++i) {
            queue.poll();
        }
        return queue.isEmpty() ? Integer.MIN_VALUE : queue.peek();
    }

}
