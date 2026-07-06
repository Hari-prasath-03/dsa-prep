public class SearchA2DMatrix {
    static boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) return true;
            else if (target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[] curr = matrix[mid];

            if (curr[0] <= target && target <= curr[curr.length - 1]) return binarySearch(curr, target);
            else if (curr[0] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = (n * m) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int curr = matrix[mid / m][mid % m];

            if (curr == target) return true;
            else if (target > curr) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
    static void main() {
        System.out.println(searchMatrix1(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3));
        System.out.println(searchMatrix1(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 13));
    }
}
