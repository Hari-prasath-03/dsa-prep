package greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static int minNumOfRemoval(int[][] nums) {
        int remove = 0, end = Integer.MIN_VALUE;
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);

        for (int[] num: nums) {
            if (end <= num[0]) end = num[1];
            else remove++;
        }
        return remove;
    }

    public static void main(String[] args) {
        System.out.println(minNumOfRemoval(new int[][] {{1,2},{2,3},{3,4},{1,3}})); // 1
        System.out.println(minNumOfRemoval(new int[][] {{1,2},{1,2},{1,2}})); // 2
        System.out.println(minNumOfRemoval(new int[][] {{1,2},{2,3}})); // 0
    }
}
