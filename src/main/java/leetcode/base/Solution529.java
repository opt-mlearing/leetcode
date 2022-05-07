package leetcode.base;

/**
 * 529. 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/
 */
public class Solution529 {

    private int m;
    private int n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        int count = 0;
        for (int i = 0; i < direction.length; ++i) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (board[nx][ny] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            board[x][y] = (char) (count + '0');
        } else {
            // 只有'B'才继续递归搜索.
            board[x][y] = 'B';
            for (int i = 0; i < direction.length; ++i) {
                int xx = x + direction[i][0];
                int yy = y + direction[i][1];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n || board[xx][yy] == 'B') {
                    continue;
                }
                dfs(board, xx, yy);
            }
        }
    }

}
