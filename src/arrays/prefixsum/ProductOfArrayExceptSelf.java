package arrays.prefixsum;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExpectSelf(int[] nums) {
        int n = nums.length;
        int[] l = new int[n], r = new int[n];

        l[0] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }

        r[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            r[i] = nums[i + 1] * r[i + 1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = r[i] * l[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExpectSelf(new int[] {1, 2, 3, 4}))); // [24,12,8,6]
        System.out.println(Arrays.toString(productExpectSelf(new int[] {-1,1,0,-3,3}))); // [0,0,9,0,0]
    }
}
