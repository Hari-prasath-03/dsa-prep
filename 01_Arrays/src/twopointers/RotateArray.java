package twopointers;

import java.util.Arrays;

public class RotateArray {
    private static void rotate(int[] nums, int s, int e) {
        while (s < e) {
            int t = nums[s];
            nums[s] = nums[e];
            nums[e] = t;
            s++;
            e--;
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        rotate(nums, 0, n - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, n - 1);
    }

    public static void main(String[] args) {
        int[] t1 = {1, 2, 3, 4, 5, 6, 7}; // [5,6,7,1,2,3,4]
        int[] t2 = {-1,-100,3,99}; // [3,99,-1,-100]
        rotate(t1, 3);
        rotate(t2, 2);
        System.out.println(Arrays.toString(t1));
        System.out.println(Arrays.toString(t2));
    }
}
