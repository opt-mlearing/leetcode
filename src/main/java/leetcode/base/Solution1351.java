package leetcode.base;

/**
 * 1351. 统计有序矩阵中的负数
 * https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class Solution1351 {

    public int countNegatives(int[][] grid) {
        int size = grid.length;
        int res = 0;
        for (int i = 0; i < size; ++i) {
            int pos = findNegative(grid[i]);
            if (pos == -1) {
                res += grid[i].length;
            } else {
                res += (grid[i].length - 1 - pos);
            }
        }
        return res;
    }

    private int findNegative(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pos;
    }

}
