package general;

import utils.Arrays2D;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                swap(matrix, row, col);
            }
        }

        // rev every row
        for (int[] row: matrix) {
            int l = 0, r = n - 1;
            while (l < r) {
                swap(row, l++, r--);
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
    static void swap(int[][] mat, int a, int b) {
        int t = mat[a][b];
        mat[a][b] = mat[b][a];
        mat[b][a] = t;
    }

    static void main() {
        int[][] m1 = {{1,2,3}, {4,5,6}, {7,8,9}}; // [[7,4,1],[8,5,2],[9,6,3]]
        int[][] m2 = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}}; // [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        rotate(m1);
        rotate(m2);
        Arrays2D.print2dArray(m1);
        Arrays2D.print2dArray(m2);
    }
}
