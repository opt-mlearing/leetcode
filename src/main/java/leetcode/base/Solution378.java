package leetcode.base;

/**
 * 378. 有序矩阵中第 K 小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class Solution378 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isKth(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isKth(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int size = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                size += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return size >= k;
    }

}
