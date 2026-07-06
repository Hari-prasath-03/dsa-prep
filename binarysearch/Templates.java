public class Templates {

    static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    static int findFirstOccurrence(int[] nums, int target) {
        int ans = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                if (nums[mid] == target) ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }

        return ans;
    }

    static int findLastOccurrence(int[] nums, int target) {
        int ans = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                if (nums[mid] == target) ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }

        return ans;
    }

    static void main() {
        System.out.println(binarySearch(new int[] {-1,0,3,5,9,12}, 9)); // 4
        System.out.println(binarySearch(new int[] {-1,0,3,5,9,12}, 2)); // -1

        System.out.println(findFirstOccurrence(new int[] {1, 3, 5, 5, 5, 5, 7, 9}, 5)); // 2
        System.out.println(findFirstOccurrence(new int[] {2, 2, 2, 4, 6, 8}, 2)); // 0

        System.out.println(findLastOccurrence(new int[] {1, 3, 5, 5, 5, 5, 7, 9}, 5)); // 5
        System.out.println(findLastOccurrence(new int[] {2, 2, 2, 4, 6, 8}, 2)); // 2
    }
}
