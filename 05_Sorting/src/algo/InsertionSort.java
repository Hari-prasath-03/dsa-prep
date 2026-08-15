package algo;

import java.util.Arrays;

public class InsertionSort {
    static void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j--];
            }
            nums[j + 1] = key;
        }
    }

    static void main() {
        int[] arr1 = {5, 3, 8, 1};
        int[] arr2 = {3, 5, 1, 5, 7, 2, 8, 9, 0, 10};
        insertionSort(arr1);
        insertionSort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
