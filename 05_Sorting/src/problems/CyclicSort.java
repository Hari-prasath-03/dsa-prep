package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {
    public static int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;

        while (i < n) {
            int corrIdx = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[corrIdx]) swap(nums, i, corrIdx);
            else i++;
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        /*int sum = (n * (n + 1)) / 2;
        int total = sum(nums);
        return sum - total;*/

        int i = 0;
        while (i < n) {
            int corrIdx = nums[i];
            if (nums[i] < n && nums[i] != nums[corrIdx]) swap(nums, i, corrIdx);
            else i++;
        }

        for (i = 0; i < n; i++) {
            if (nums[i] !=  i) return i;
        }

        return n;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int i = 0, n = nums.length;
        while (i < n) {
            int corrIdx = nums[i] - 1;
            if (nums[i] != nums[corrIdx]) swap(nums, i, corrIdx);
            else i++;
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) list.add(nums[i]);
        }
        return list;
    }

    static void main() {

        System.out.println(firstMissingPositive(new int[] {1,2,0}));
        System.out.println(firstMissingPositive(new int[] {3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[] {7,8,9,11,12}));

        System.out.println(missingNumber(new int[] {3,0,1}));
        System.out.println(missingNumber(new int[] {0,1}));
        System.out.println(missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));

        System.out.println(findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
        System.out.println(findDuplicates(new int[] {1,1,2}));
        System.out.println(findDuplicates(new int[] {1}));
    }

    static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
