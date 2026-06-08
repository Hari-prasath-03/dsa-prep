package arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static int contiguousArray(int[] nums) {
        int prefixSum = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 0) ? -1 : 1;

            if (prefixSum == 0) maxLen = i + 1;
            if (map.containsKey(prefixSum)) maxLen = Math.max(maxLen, i - map.get(prefixSum));
            else map.put(prefixSum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(contiguousArray(new int[] {0, 1})); // 2
        System.out.println(contiguousArray(new int[] {0, 1, 0})); // 2
        System.out.println(contiguousArray(new int[] {0,1,1,1,1,1,0,0,0})); // 6
        System.out.println(contiguousArray(new int[] {1,0,1,0,1,1,0,0,1,0,1,1})); // 10
    }
}
