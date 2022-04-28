package leetcode.offer;

/**
 * 剑指 Offer II 112. 最长递增路径
 * https://leetcode-cn.com/problems/fpTFWP/
 */
public class SolutionOffer_II_112 {

    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int res = 0;
    private int[][] lengthMatrix = null;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        lengthMatrix = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(i, j, m, n, matrix);
            }
        }
        return res;
    }

    private int dfs(int i, int j, int m, int n, int[][] matrix) {
        if (lengthMatrix[i][j] != 0) {
            return lengthMatrix[i][j];
        }
        lengthMatrix[i][j] = 1;
        for (int k = 0; k < direction.length; ++k) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] > matrix[x][y]) {
                lengthMatrix[i][j] = Math.max(lengthMatrix[i][j], dfs(x, y, m, n, matrix) + 1);
            }
        }
        res = Math.max(res, lengthMatrix[i][j]);
        return lengthMatrix[i][j];
    }

}
