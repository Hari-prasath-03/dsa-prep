package arrays.twopointers;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int l = 0, r = 1;

        while (r < nums.length) {
            if (nums[l] != nums[r]) nums[++l] = nums[r];
            r++;
        }
        return l + 1;
    }

    static void main() {
        int[] arr1 = {1,1,2}, arr2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr1) + " " + Arrays.toString(arr1)); // 2, [1,2,_]
        System.out.println(removeDuplicates(arr2) + " " + Arrays.toString(arr2)); // 5, [0,1,2,3,4,_,_,_,_,_]
    }
}
