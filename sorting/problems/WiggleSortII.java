package sorting.problems;

import java.util.Arrays;

public class WiggleSortII {
    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] res = new int[n];

        int mid = (n - 1) / 2;
        int i = mid, j = n - 1, idx = 0;
        while (i >= 0 || j > mid) {
            if (idx % 2 == 0) res[idx] = nums[i--];
            else res[idx] = nums[j--];
            idx++;
        }

        System.arraycopy(res, 0, nums, 0, n);
    }

    static void main() {
        int[] a1 = {1,5,1,1,6,4}; // [1,6,1,5,1,4]
        int[] a2 = {1,3,2,2,3,1}; // [2,3,1,3,1,2]
        wiggleSort(a1);
        wiggleSort(a2);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }
}
