package sorting.algo;

import java.util.Arrays;

public class MergeSort {
    static void mergeSortInplace(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        if (nums[mid] <= nums[mid + 1]) return;
        merge(nums, start, mid, end);
    }

    static void merge(int[] nums, int start, int mid, int end) {
        int n1 = mid - start + 1, n2 = end - mid;

        int[] arr1 = new int[n1], arr2 = new int[n2];
/*        for (int i = 0; i < n1; i++) arr1[i] = nums[start + i];
        for (int i = 0; i < n2; i++) arr2[i] = nums[mid + 1 + i];*/
        System.arraycopy(nums, start, arr1, 0, n1);
        System.arraycopy(nums, mid + 1, arr2, 0, n2);

        int i = 0, j = 0, index = start;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) nums[index] = arr1[i++];
            else nums[index] = arr2[j++];
            index++;
        }

        while (i < n1) nums[index++] = arr1[i++];
        while (j < n2) nums[index++] = arr2[j++];
    }

    static void main() {
        int[] arr1 = {5,3,8,1};
        int[] arr2 = {3,5,1,5,7,2,8,9,0,10};
        mergeSortInplace(arr1);
        mergeSortInplace(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}


/*
        Array copy

        int[] nums = {3,5,1,5,7,2,8,9,0,10};
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;

        int n1 = mid - start + 1, n2 = end - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        System.arraycopy(nums, start, arr1, 0, n1);
        System.arraycopy(nums, n1, arr2, 0, n2);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

*/
