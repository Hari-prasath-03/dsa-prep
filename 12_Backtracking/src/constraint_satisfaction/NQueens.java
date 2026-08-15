package constraint_satisfaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    private static List<List<String>> res;

    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        backtrack(0, 0, board, n);
        return res;
    }

    private static void backtrack(int row, int col, char[][] board, int n) {
        if (col == n) {
            res.add(construct(board));
            return;
        }
        if (row == n) return;

        if (isValid(board, row, col, n)) {
            board[row][col] = 'Q';
            backtrack(0, col + 1, board, n);
            board[row][col] = '.';
        }
        backtrack(row + 1, col, board, n);
    }

    private static void backtrack(int col, char[][] board, int n) {
        if (col == n) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(col + 1, board, n);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++) { // same row
            if (board[row][i] == 'Q') return false;
        }
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) { // upper-left diagonal
            if (board[row - i][col - i] == 'Q') return false;
        }
        for (int i = 1; row + i < n && col - i >= 0; i++) { // lower-left diagonal
            if (board[row + i][col - i] == 'Q') return false;
        }
        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row: board) list.add(new String(row));
        return list;
    }

    static void main() {
        System.out.println(solveNQueens(4)); // [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        System.out.println(solveNQueens(1)); // [["Q"]]
    }
}
