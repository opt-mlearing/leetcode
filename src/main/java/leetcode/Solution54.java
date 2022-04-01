package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right && top <= down) {
            for (int i = left; i <= right; ++i) {
                res.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= down; ++i) {
                res.add(matrix[i][right]);
            }
            // 注意这里面一定需要判断下，避免取重复的.
            if (left < right && top < down) {
                for (int i = right - 1; i > left; --i) {
                    res.add(matrix[down][i]);
                }
                for (int i = down; i > top; --i) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            top++;
            right--;
            down--;
        }
        return res;
    }

}
