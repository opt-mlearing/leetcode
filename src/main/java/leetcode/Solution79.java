package leetcode;

/**
 * 单词搜索.
 * https://leetcode-cn.com/problems/word-search/
 */
public class Solution79 {

    private int[][] orientation = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                boolean state = dfs(board, visit, i, j, 0, word);
                if (state) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visit, int m, int n, int index, String word) {
        // 结束条件
        if (word.charAt(index) != board[m][n]) {
            return false;
        } else if (index == word.length() - 1) {
            // word全部搜索完成,且都匹配上.
            return true;
        }
        visit[m][n] = true;
        for (int i = 0; i < orientation.length; ++i) {
            int newM = m + orientation[i][0];
            int newN = n + orientation[i][1];
            if (newM < 0 || newM >= board.length || newN < 0 || newN >= board[0].length || visit[newM][newN]) {
                continue;
            }
            boolean tmp = dfs(board, visit, newM, newN, index + 1, word);
            if (tmp) {
                return true;
            }
        }
        // 回溯，回置状态.
        visit[m][n] = false;
        return false;
    }

}
