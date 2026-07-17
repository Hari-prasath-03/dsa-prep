package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleInHistogram {
    static int[] nextSmallestElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, n);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
            if (!stack.isEmpty()) res[i] = stack.peek();
            stack.push(i);
        }
        return res;
    }

    static int[] previousSmallestElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
            if (!stack.isEmpty()) res[i] = stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] next = nextSmallestElements(heights);
        int[] prev = previousSmallestElements(heights);

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (next[i] - prev[i] - 1));
        }
        return maxArea;
    }

    static void main() {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3})); // 10
        System.out.println(largestRectangleArea(new int[] {2,4})); // 4
    }
}
