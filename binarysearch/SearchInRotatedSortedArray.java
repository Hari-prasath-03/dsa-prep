public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[left] <= nums[mid]) { // is left half sorted
                if (nums[left] <= target && nums[mid] >= target) right = mid - 1;
                else left = mid + 1;
            } else { // right half is sorted
                if (nums[mid] <= target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1;
    }

    static void main() {
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 4)); // 0
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 3)); // - 1
        System.out.println(search(new int[] {1}, 0)); // - 1
    }
}
