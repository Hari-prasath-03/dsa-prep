package matrix;

import utils.Utils;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        boolean[] rows = new boolean[r];
        boolean[] cols = new boolean[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (rows[j]) matrix[j][i] = 0;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (cols[j]) matrix[i][j] = 0;
            }
        }
    }

    static void main() {
        int[][] m1 = {{1,1,1}, {1,0,1}, {1,1,1}};
        int[][] m2 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        setZeroes(m1); // [[1,0,1],[0,0,0],[1,0,1]]
        setZeroes(m2); // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        Utils.print2dArray(m1);
        Utils.print2dArray(m2);
    }
}
