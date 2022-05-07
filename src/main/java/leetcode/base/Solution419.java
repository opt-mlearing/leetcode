package leetcode.base;

/**
 * 419. 甲板上的战舰
 * https://leetcode-cn.com/problems/battleships-in-a-board/
 */
public class Solution419 {

    private static final int[][] direction = {{0, 1}, {1, 0}};
    private int m;
    private int n;

    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.' || board[i][j] == 'Y') {
                    continue;
                }
                dfs(board, i, j);
                count++;
            }
        }
        return count;
    }

    private void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'Y') {
            return;
        }
        board[x][y] = 'Y';
        for (int i = 0; i < direction.length; ++i) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || board[nx][ny] == 'Y' || board[nx][ny] == '.') {
                continue;
            }
            dfs(board, nx, ny);
        }
    }

}
