package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 040. 矩阵中最大的矩形
 * https://leetcode-cn.com/problems/PLYXKQ/
 */
public class SolutionOffer2_040 {

    public int maximalRectangle(String[] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length();
        int[][] widths = new int[m][n];
        // 获取宽度
        for (int i = 0; i < m; ++i) {
            int pre = 0;
            for (int j = 0; j < n; ++j) {
                if (matrix[i].charAt(j) == '0') {
                    pre = 0;
                } else {
                    pre++;
                }
                widths[i][j] = pre;
            }
        }
        // 以matrix[x][y] 为矩形右下角，纵向计算矩形面积.
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] up = new int[m];
        int[] down = new int[m];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            stack.clear();
            for (int j = 0; j < m; ++j) {
                while (!stack.isEmpty() && widths[j][i] <= widths[stack.peek()][i]) {
                    stack.pop();
                }
                up[j] = (stack.isEmpty() ? -1 : stack.peek());
                stack.push(j);
            }
            stack.clear();
            for (int j = m - 1; j >= 0; --j) {
                while (!stack.isEmpty() && widths[j][i] < widths[stack.peek()][i]) {
                    stack.pop();
                }
                down[j] = (stack.isEmpty() ? m : stack.peek());
                stack.push(j);
            }
            // 计算面积
            for (int j = 0; j < m; ++j) {
                if (matrix[j].charAt(i) == '0') {
                    continue;
                }
                res = Math.max(res, (down[j] - up[j] - 1) * widths[j][i]);
            }
        }
        return res;
    }

}
