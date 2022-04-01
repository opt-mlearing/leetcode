package leetcode;

/**
 * 螺旋矩阵 II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class Solution59 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int down = n - 1;
        int num = 0;
        while (left <= right && top <= down) {
            for (int i = left; i <= right; ++i) {
                res[top][i] = ++num;
            }
            for (int i = top + 1; i <= down; ++i) {
                res[i][right] = ++num;
            }
            if (left < right && top < down) {
                for (int i = right - 1; i > left; --i) {
                    res[down][i] = ++num;
                }
                for (int i = down; i > top; --i) {
                    res[i][left] = ++num;
                }
            }
            left++;
            right--;
            top++;
            down--;
        }
        return res;
    }

}
