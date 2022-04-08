package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大矩形
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class Solution85 {

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] widths = new int[row][col];
        for (int i = 0; i < row; ++i) {
            int pre = 0;
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == '1') {
                    pre = pre + 1;
                } else {
                    pre = 0;
                }
                widths[i][j] = pre;
            }
        }
        // 以matrix[i][j]为右下角的矩形面积.
        int res = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                res = Math.max(res, findColMax(widths, j));
            }
        }
        return res;
    }

    private int findColMax(int[][] widths, int col) {
        int size = widths.length;
        int[] up = new int[size];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < size; ++i) {
            while (!stack.isEmpty() && widths[i][col] <= widths[stack.peek()][col]) {
                stack.pop();
            }
            up[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        int[] dowm = new int[size];
        stack.clear();
        for (int i = size - 1; i >= 0; --i) {
            while (!stack.isEmpty() && widths[i][col] < widths[stack.peek()][col]) {
                stack.pop();
            }
            dowm[i] = (stack.isEmpty() ? size : stack.peek());
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < size; ++i) {
            res = Math.max(res, (dowm[i] - up[i] - 1) * (widths[i][col]));
        }
        return res;
    }

}
