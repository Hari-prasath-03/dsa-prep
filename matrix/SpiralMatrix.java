import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        spiralOrder(matrix, list, 0, matrix[0].length - 1, 0, matrix.length - 1);
        return list;
    }
    static void spiralOrder(int[][] matrix, List<Integer> list, int l, int r, int t, int b) {
        if (!(l <= r && t <= b)) return;

        for (int i = l; i <= r; i++) {
            list.add(matrix[t][i]);
        }
        t++;

        for (int i = t; i <= b; i++) {
            list.add(matrix[i][r]);
        }
        r--;

        if (t <= b)
            for (int i = r; i >= l; i--) {
                list.add(matrix[b][i]);
            }
        b--;

        if (l <= r)
            for (int i = b; i >= t ; i--) {
                list.add(matrix[i][l]);
            }
        l++;

        spiralOrder(matrix, list, l, r, t, b);
    }

    static void printSpiralOrder(int[][] matrix) {
        printSpiralOrder(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1);
    }
    static void printSpiralOrder(int[][] matrix, int l, int r, int t, int b) {
        if (!(l <= r && t <= b)) return;

        for (int i = l; i <= r; i++) {
            System.out.print(matrix[t][i] + " ");
        }
        t++;

        for (int i = t; i <= b; i++) {
            System.out.print(matrix[i][r] + " ");
        }
        r--;

        if (t <= b)
            for (int i = r; i >= l; i--) {
                System.out.print(matrix[b][i] + " ");
            }
        b--;

        if (l <= r)
            for (int i = b; i >= t ; i--) {
                System.out.print(matrix[i][l] + " ");
            }
        l++;

        printSpiralOrder(matrix, l, r, t, b);
    }

    static void main() {
        int[][] m1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] m2 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(spiralOrder(m1));
        System.out.println(spiralOrder(m2));
    }
}
