package constraint_satisfaction;

import utils.Arrays2D;

public class SudokuSolver {
    private final static int BOARD_SIZE = 9;

    public static void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    public static boolean solve(char[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;
                            if (solve(board)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudoku(char[][] board, int row, int col) {
        if (row == BOARD_SIZE) return true;
        if (col == BOARD_SIZE) return solveSudoku(board, row + 1, 0);
        if (board[row][col] != '.') return solveSudoku(board, row, col + 1);
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (solveSudoku(board, row, col + 1)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == c || board[i][col] == c ||
            board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }

    static void main() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        Arrays2D.print2dArray(board);
    }
}
