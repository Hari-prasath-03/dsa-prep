package sorting.algo;

import java.util.Arrays;

public class BubbleSort {
    static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // online swap. formula: b = (a + b) - (a = b);
                    nums[j + 1] = (nums[j] + nums[j + 1]) - (nums[j] = nums[j + 1]);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    static void main() {
        int[] arr1 = {5,3,8,1};
        int[] arr2 = {3,5,1,5,7,2,8,9,0,10};
        bubbleSort(arr1);
        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
