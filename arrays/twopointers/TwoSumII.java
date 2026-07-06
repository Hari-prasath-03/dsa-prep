package twopointers;

import java.util.Arrays;

public class TwoSumII {
    public static int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) return new int[] {l+1, r+1};
            else if (sum > target) r--;
            else l++;
        }
        return new int[] {-1, -1};
    }

    static void main() {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[] {2,3,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[] {-1,0}, -1)));
    }
}
