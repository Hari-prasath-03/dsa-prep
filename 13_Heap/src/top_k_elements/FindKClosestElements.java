package top_k_elements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int num: arr) {
            if (k > 0) {
                heap.offer(num);
                k--;
            } else if (!heap.isEmpty() && Math.abs(num - x) < Math.abs(heap.peek() - x)) {
                heap.poll();
                heap.offer(num);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!heap.isEmpty()) list.add(heap.poll());
        return list;
    }

    static void main() {
        System.out.println(findClosestElements(new int[] {1,2,3,4,5}, 4, 3));
        System.out.println(findClosestElements(new int[] {1,1,2,3,4,5}, 4, -1));
    }
}
