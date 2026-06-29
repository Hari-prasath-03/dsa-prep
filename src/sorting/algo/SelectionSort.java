package sorting.algo;

import java.util.Arrays;

public class SelectionSort {
    static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minI]) minI = j;
            }
            if (minI != i) nums[minI] = (nums[i] + nums[minI]) - (nums[i] = nums[minI]);
        }
    }

    static void main() {
        int[] arr1 = {5,3,8,1};
        int[] arr2 = {3,5,1,5,7,2,8,9,0,10};
        selectionSort(arr1);
        selectionSort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
