package problems;

import java.util.Arrays;

public class MoveZeros {
    static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void moveZeroes(int[] nums) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) swap(nums, l++, i);
        }
    }

    static void main() {
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0};
        moveZeroes(nums1); // [1,3,12,0,0]
        moveZeroes(nums2); // [0]
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}
