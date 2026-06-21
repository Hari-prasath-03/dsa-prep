package arrays.matrix;

public class MagicSquaresGrid {
    static boolean isMagic(int[][] grid, int r, int c) {
        boolean[] seen = new boolean[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) return false;
                seen[num] = true;
            }
        }

        int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];

        for (int i = r; i < r + 3; i++) {
            if (grid[i][c] + grid[i][c + 1] + grid[i][c + 2] != sum) return false;
        }
        for (int i = c; i < c + 3; i++) {
            if (grid[r][i] + grid[r + 1][i] + grid[r + 2][i] != sum) return false;
        }
        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != sum) return false;
        if (grid[r + 2][c] + grid[r + 1][c + 1] + grid[r][c + 2] != sum) return false;
        return true;
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        if (r < 3 || c < 3) return 0;
        int count = 0;

        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c - 2; j++) {
                if (isMagic(grid, i, j)) count++;
            }
        }

        return count;
    }

    static void main() {
        System.out.println(numMagicSquaresInside(new int[][] {{4,3,8,4}, {9,5,1,9}, {2,7,6,2}})); // 1
        System.out.println(numMagicSquaresInside(new int[][] {{8}})); // 0
        System.out.println(numMagicSquaresInside(new int[][] {{2,7,6}, {1,5,9}, {4,3,8}})); // 0
        System.out.println(numMagicSquaresInside(new int[][] {{4,3,8,4},{9,5,1,9},{2,7,6,2},{4,3,8,4},{9,5,1,9},{2,7,6,2}})); // 2
    }
}
