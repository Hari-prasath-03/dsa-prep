package arrays.twopointers;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];

        int l = 0, r = n - 1, idx = n - 1;
        while (l <= r) {
            if (Math.abs(nums[r]) > Math.abs(nums[l])) squares[idx] = nums[r] * nums[r--];
            else squares[idx] = nums[l] * nums[l++];
            idx--;
        }

        return squares;
    }

    static void main() {
        System.out.println(Arrays.toString(sortedSquares(new int[] {-4,-1,0,3,10})));
        System.out.println(Arrays.toString(sortedSquares(new int[] {-7,-3,2,3,11})));
    }
}
