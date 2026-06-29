package matrix;

public class ValidSudoku {
    static boolean containDuplicate(char... arr) {
        boolean[] seen = new boolean[10];

        for(char c: arr) {
            if (c != '.') {
                if (seen[c - '0']) return true;
                seen[c - '0'] = true;
            }
        }
        return false;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            if (containDuplicate(row)) return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (containDuplicate(board[0][i], board[1][i], board[2][i],
                    board[3][i], board[4][i], board[5][i], board[6][i],
                    board[7][i], board[8][i])) return false;
        }

        for (int i = 0; i < board.length; i++) {
            int row = i / 3 * 3;
            int col = i % 3 * 3;
            if (containDuplicate(board[row][col], board[row][col + 1], board[row][col + 2],
                    board[row + 1][col], board[row + 1][col + 1], board[row + 1][col + 2],
                    board[row + 2][col], board[row + 2][col + 1], board[row + 2][col + 2])) return false;
        }

        return true;
    }

    static void main() {
        char[][] m1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] m2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(m1));
        System.out.println(isValidSudoku(m2));
    }
}
