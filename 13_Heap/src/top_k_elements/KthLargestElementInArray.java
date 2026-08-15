package top_k_elements;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }

        return heap.poll();
    }

    static void main() {
        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2)); // 5
        System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4)); // 4
    }
}
