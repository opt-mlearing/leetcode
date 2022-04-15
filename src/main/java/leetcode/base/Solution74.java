package leetcode.base;

/**
 * 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = columnBinarySearch(matrix, target);
        if (rowIndex == -1) {
            return false;
        }
        return rowBinarySearch(matrix[rowIndex], target);
    }

    private int columnBinarySearch(int[][] matrix, int target) {
        int start = -1;
        int end = matrix.length - 1;
        while (start < end) {
            int mid = (start + end + 1) >> 1;
            if (matrix[mid][0] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private boolean rowBinarySearch(int[] rows, int target) {
        int left = 0;
        int right = rows.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (rows[mid] < target) {
                left = mid + 1;
            } else if (rows[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
