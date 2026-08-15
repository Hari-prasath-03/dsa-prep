package kadanes_algo;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;
        for (int num: nums) {
            if (sum < 0) sum = 0;
            sum += num;
            max = Math.max(sum, max);
        }
        return max;
    }

    static void main() {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println(maxSubArray(new int[] {1})); // 1
        System.out.println(maxSubArray(new int[] {5,4,-1,7,8})); // 23
    }
}
