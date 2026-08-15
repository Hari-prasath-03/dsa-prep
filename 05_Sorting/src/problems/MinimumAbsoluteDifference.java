package problems;

import utils.Arrays2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        for (int i = 1; i < arr.length; i++) {
            if (minDiff == (arr[i] - arr[i - 1])) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }

    static void main() {
        System.out.println(minimumAbsDifference(new int[] {4,2,1,3}));
        System.out.println(minimumAbsDifference(new int[] {1,3,6,10,15}));
        System.out.println(minimumAbsDifference(new int[] {3,8,-10,23,19,-4,-14,27}));
    }
}
