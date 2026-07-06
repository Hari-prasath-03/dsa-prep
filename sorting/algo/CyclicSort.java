package algo;

public class CyclicSort {
    static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    static void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int corrIdx = nums[i] - 1;
            if (nums[i] != nums[corrIdx]) swap(nums, i, corrIdx);
            else i++;
        }
    }

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

    static void main() {
//        int[] a1 = {3, 5, 2, 1, 4};
//        int[] a2 = {5, 4, 3, 2, 1};
        System.out.println(firstMissingPositive(new int[] {1,2,0}));
        System.out.println(firstMissingPositive(new int[] {3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[] {7,8,9,11,12}));

    }
}
