package problems;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];

        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) nums[index] = nums1[i++];
            else nums[index] = nums2[j++];
            index++;
        }

        while (i < m) nums[index++] = nums1[i++];
        while (j < n) nums[index++] = nums2[j++];

        System.arraycopy(nums, 0, nums1, 0, m + n);
    }

    static void main() {
        int[] a1n1 = {1, 2, 3, 0, 0, 0}, a1n2 = {2, 5, 6};
        merge(a1n1, 3, a1n2, 3);
        System.out.println(Arrays.toString(a1n1));

        int[] a2n1 = {1}, a2n2 = {0};
        merge(a2n1, 1, a2n2, 0);
        System.out.println(Arrays.toString(a2n1));

        int[] a3n1 = {0}, a3n2 = {1};
        merge(a3n1, 0, a3n2, 1);
        System.out.println(Arrays.toString(a3n1));
    }
}
