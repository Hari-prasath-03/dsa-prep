package fast_slow;

public class FindTheDuplicateNumber {
    // time must: O(N) and space: O(1)
    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    static void main() {
        System.out.println(findDuplicate(new int[] {1,3,4,2,2})); // 2
        System.out.println(findDuplicate(new int[] {3,1,3,4,2})); // 3
        System.out.println(findDuplicate(new int[] {3,3,3,3,3})); // 3
    }
}
