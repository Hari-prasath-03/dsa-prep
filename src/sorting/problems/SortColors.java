package sorting.problems;

import java.util.Arrays;

public class SortColors {
    static void swap(int[] nums, int a, int b) {
        // online swap formula: b = (a + b) - (a = b)
        nums[b] = (nums[a] + nums[b]) - (nums[a] = nums[b]);
    }
    public static void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            if (nums[j] == 0) swap(nums, i++, j++);
            else if (nums[j] == 1) j++;
            else swap(nums, j, k--);
        }
    }

    static void main() {
        int[] a1 = {2,0,2,1,1,0};
        int[] a2 = {2,0,1};
        sortColors(a1);
        sortColors(a2);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }
}
