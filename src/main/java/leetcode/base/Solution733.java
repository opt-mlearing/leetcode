package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 图像渲染
 * https://leetcode-cn.com/problems/flood-fill/
 */
public class Solution733 {

    // 宽度优先搜索.
    public int[][] floodFill_by_bfs(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if (target == newColor) {
            return image;
        }
        int[] x = {0, -1, 1, 0};
        int[] y = {-1, 0, 0, 1};
        Deque<int[]> deque = new LinkedList<int[]>();
        deque.offer(new int[]{sr, sc});
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                int[] tmp = deque.poll();
                for (int j = 0; j < 4; ++j) {
                    image[tmp[0]][tmp[1]] = newColor;
                    int row = tmp[0] + x[j];
                    int column = tmp[1] + y[j];
                    if (row < 0 || row >= image.length || column < 0
                            || column >= image[row].length || image[row][column] != target) {
                        continue;
                    }
                    deque.offer(new int[]{row, column});
                }
            }
        }
        return image;
    }

    public int[][] floodFill_by_dfs(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if (target != newColor) {
            dfs(image, sr, sc, target, newColor);
        }
        return image;
    }

    // 深度优先搜索.
    private void dfs(int[][] image, int row, int column, int target, int newColor) {
        if (row < 0 || row >= image.length || column < 0
                || column >= image[row].length || image[row][column] != target) {
            return;
        }
        image[row][column] = newColor;
        dfs(image, row - 1, column, target, newColor);
        dfs(image, row + 1, column, target, newColor);
        dfs(image, row, column - 1, target, newColor);
        dfs(image, row, column + 1, target, newColor);
    }

}
