package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySumEqualsK(int[] nums, int k) {
        int prefixSum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num: nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) count += map.get(prefixSum - k);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySumEqualsK(new int[] {1, 1, 1}, 2)); // 2
        System.out.println(subarraySumEqualsK(new int[] {1, 2, 3}, 3)); // 2
        System.out.println(subarraySumEqualsK(new int[] {3, 4, 2, 5, 7, 1, 1, 4, 1, 6, 1}, 7)); // 6
    }
}
