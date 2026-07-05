package binarysearch;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[m + 1]) l = m + 1;
            else r = m;
        }
        return l;
    }

    static void main() {
        System.out.println(findPeakElement(new int[] {1,2,3,1}));
        System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));
    }
}
