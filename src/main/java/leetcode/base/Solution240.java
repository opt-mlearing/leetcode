package leetcode.base;

/**
 * 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0) {
            return false;
        }
        for (int[] arr : matrix) {
            if (binarySearch(arr, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] datas, int target) {
        if (datas == null || datas.length == 0) {
            return false;
        }
        int left = 0;
        int right = datas.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (datas[mid] == target) {
                return true;
            } else if (datas[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
