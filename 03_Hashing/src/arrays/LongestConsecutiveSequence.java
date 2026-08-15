package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        int longest = 0;
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int curr = 1;
                while (set.contains(num + curr)) curr++;
                longest = Math.max(curr, longest);
            }
        }
        return longest;
    }

    static void main() {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2})); // 4
        System.out.println(longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1})); // 9
        System.out.println(longestConsecutive(new int[] {1,0,1,2})); // 3
    }
}

