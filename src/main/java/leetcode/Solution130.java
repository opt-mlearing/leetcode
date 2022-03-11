package leetcode;

public class Solution130 {

    private int rowSize;
    private int columnSize;

    public void solve(char[][] board) {
        rowSize = board.length;
        if (rowSize == 0) {
            return;
        }
        columnSize = board[0].length;
        // 扫描全部的边框
        for (int i = 0; i < rowSize; ++i) {
            dfs(board, i, 0);
            dfs(board, i, columnSize - 1);
        }
        // 注意，避开第一和最后一列.
        for (int i = 1; i < columnSize - 1; ++i) {
            dfs(board, 0, i);
            dfs(board, rowSize - 1, i);
        }
        // 对标记进行处理
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < columnSize; ++j) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    // dfs最初开始的位置认为是可以找符合条件起点，若这个起点的位置不是‘0’，那么就不需要递归下去寻找.
    private void dfs(char[][] board, int row, int column) {
        if ((row < 0) || (row >= rowSize) || (column < 0) || (column >= columnSize) || board[row][column] != 'O') {
            return;
        }
        if (board[row][column] == 'O') {
            board[row][column] = 'A';
        }
        dfs(board, row - 1, column);
        dfs(board, row + 1, column);
        dfs(board, row, column - 1);
        dfs(board, row, column + 1);
    }

}
