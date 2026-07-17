package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    public static int[] nextLargestElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
            if (!stack.isEmpty()) res[i] = stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static int[] nextSmallestElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) stack.pop();
            if (!stack.isEmpty()) res[i] = stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static int[] previousGreatestElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
            if (!stack.isEmpty()) res[i] = stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static int[] previousSmallestElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) stack.pop();
            if (!stack.isEmpty()) res[i] = stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    static void main() {
        System.out.println(Arrays.toString(previousGreatestElement(new int[] {1, 3, 2, 4})));
        System.out.println(Arrays.toString(previousGreatestElement(new int[] {6, 8, 0, 1, 3})));
        System.out.println(Arrays.toString(previousGreatestElement(new int[] {50, 40, 30, 20, 10})));
        System.out.println(Arrays.toString(previousGreatestElement(new int[] {4,12,5,3,1,2,5,3,1,2,4,6})));
    }
}
