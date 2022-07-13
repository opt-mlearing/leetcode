package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 733. 图像渲染
 * https://leetcode.cn/problems/flood-fill/
 *
 * @author: caogl
 * @date: 2022/7/13, 22:49
 **/
public class Solution733 {

    private static final int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    // 宽度优先搜索.
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if (target == newColor) {
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        Deque<int[]> deque = new LinkedList<int[]>();
        deque.offer(new int[]{sr, sc});
        while (!deque.isEmpty()) {
            int[] tmp = deque.poll();
            image[tmp[0]][tmp[1]] = newColor;
            for (int i = 0; i < direction.length; ++i) {
                int row = tmp[0] + direction[i][0];
                int column = tmp[1] + direction[i][1];
                if (row >= 0 && row < m && column >= 0 && column < n && image[row][column] == target) {
                    deque.offer(new int[]{row, column});
                }
            }
        }
        return image;
    }

    // 宽度优先搜索.
    public int[][] floodFill_bfs(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if (target == newColor) {
            return image;
        }
        Deque<int[]> deque = new LinkedList<int[]>();
        deque.offer(new int[]{sr, sc});
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                int[] tmp = deque.poll();
                for (int j = 0; j < direction.length; ++j) {
                    image[tmp[0]][tmp[1]] = newColor;
                    int row = tmp[0] + direction[j][0];
                    int column = tmp[1] + direction[j][1];
                    if (row < 0 || row >= image.length || column < 0 || column >= image[row].length || image[row][column] != target) {
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
        if (row < 0 || row >= image.length || column < 0 || column >= image[row].length || image[row][column] != target) {
            return;
        }
        image[row][column] = newColor;
        dfs(image, row - 1, column, target, newColor);
        dfs(image, row + 1, column, target, newColor);
        dfs(image, row, column - 1, target, newColor);
        dfs(image, row, column + 1, target, newColor);
    }

}
