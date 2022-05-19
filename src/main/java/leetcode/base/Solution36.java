package leetcode.base;

/**
 * 36. 有效的数独
 * https://leetcode.cn/problems/valid-sudoku/
 */
public class Solution36 {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] boxs = new int[3][3][9];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '1';
                rows[i][index]++;
                columns[j][index]++;
                boxs[i / 3][j / 3][index]++;
                if ((rows[i][index] > 1) || (columns[j][index] > 1) || (boxs[i / 3][j / 3][index] > 1)) {
                    return false;
                }
            }
        }
        return true;
    }

}
