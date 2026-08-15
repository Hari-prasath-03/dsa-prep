package top_k_elements;

import java.util.*;
import java.util.stream.Stream;

public class KClosestPointsToOrigin {
    public static int distanceFromOrigin(int x, int y) {
        return (int) Math.sqrt(x * x + y * y);
    }

    public static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] point: points) {
            int distance = distanceFromOrigin(point[0], point[1]);
            heap.add(new int[] {distance, point[0], point[1]});
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (k-- > 0 && !heap.isEmpty()) {
            result[i][0] = heap.peek()[1];
            result[i][1] = heap.peek()[2];
            heap.poll();
            i++;
        }
        return result;
    }

    static void main() {
        print2dArray(kClosest(new int[][] {{1,3}, {-2,2}}, 1));
        print2dArray(kClosest(new int[][] {{3,3}, {5,-1}, {-2,4}}, 2));
    }

    public static void print2dArray(int[][] arr) {
        Stream.of(arr).forEach(a -> System.out.print(Arrays.toString(a) + "\n"));
        System.out.println();
    }
}
