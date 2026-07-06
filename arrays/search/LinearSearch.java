package search;

public class LinearSearch {
    public static int search(int[] nums, int t) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == t) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {1, 100, 10, 50, -100, 7, 10}, -100));
        System.out.println(search(new int[] {1, 100, 10, 50, -100, 7, 10}, 100));
        System.out.println(search(new int[] {1, 100, 10, 50, -100, 7, 10}, 1000));
    }
}
