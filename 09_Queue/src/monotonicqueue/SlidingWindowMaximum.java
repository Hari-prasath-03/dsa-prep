package monotonicqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];

        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() == i - k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) res[i - (k - 1)] = nums[dq.peekFirst()];
        }

        return res;
    }

    public static void main() {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3))); //[3,3,5,5,6,7]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {1}, 1))); //[1]
        /*
        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7      3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7
        * */
    }
}
