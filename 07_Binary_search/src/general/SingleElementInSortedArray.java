package general;

public class SingleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int left = 1, right = n - 2; // never check the first and last
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) return nums[mid];
            else if ((mid % 2 == 1 && nums[mid - 1] == nums[mid]) ||
                    (mid % 2 == 0 && nums[mid] == nums[mid + 1])) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    static void main() {
        System.out.println(singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[] {3,3,7,7,10,11,11}));
    }
}
