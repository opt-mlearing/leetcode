package leetcode.typical;

/**
 * 面试题 08.10. 颜色填充
 * https://leetcode-cn.com/problems/color-fill-lcci/
 */
public class Solution08_10 {

    private static final int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private int m;
    private int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        if (sr >= 0 && sr < m && sc >= 0 && sc < n && newColor != image[sr][sc]) {
            dfs(image, sr, sc, newColor, image[sr][sc]);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        for (int i = 0; i < direction.length; ++i) {
            int sr1 = sr + direction[i][0];
            int sc1 = sc + direction[i][1];
            if (sr1 >= 0 && sr1 < m && sc1 >= 0 && sc1 < n) {
                dfs(image, sr1, sc1, newColor, oldColor);
            }
        }
    }

}
