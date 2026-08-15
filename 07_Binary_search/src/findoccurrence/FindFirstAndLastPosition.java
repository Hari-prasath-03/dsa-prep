package findoccurrence;

import java.util.Arrays;

public class FindFirstAndLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int first = findFirstOccurrence(nums, target);
        if (first == nums.length || nums[first] != target) return new int[] { -1, -1 };
        return new int[] { first, findFirstOccurrence(nums, target + 1) - 1  };
    }

    static int findFirstOccurrence(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    static void main() {
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[] {}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[] {1, 2, 3, 4, 5, 5, 5, 5, 5, 10}, 5)));
    }
}
