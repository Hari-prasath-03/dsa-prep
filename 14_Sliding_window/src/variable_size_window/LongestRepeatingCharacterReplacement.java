package variable_size_window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement1(String s, int k) {
        int n = s.length(), maxS = 0;
        Map<Character, Integer> hash = new HashMap<>();
        
        int maxF = 0, l = 0;
        for (int r = 0; r < n; r++) {
            char curr = s.charAt(r);

            hash.put(curr, hash.getOrDefault(curr, 0) + 1);
            maxF = Math.max(maxF, hash.get(curr));

            int windowLength = r - l + 1;
            int charsNeedToBeChanged = windowLength - maxF;

            if (charsNeedToBeChanged > k) {
                char left = s.charAt(l--);
                hash.put(left, hash.get(left) - 1);
            }
            maxS = Math.max(maxS, windowLength);
        }
        return maxS;
    }

    public static int characterReplacement2(String s, int k) {
        int n = s.length(), maxS = 0;
        int[] hash = new int[26];

        int maxF = 0, l = 0;
        for (int r = 0; r < n; r++) {
            maxF = Math.max(maxF, ++hash[s.charAt(r) - 'A']);

            if ((r - l + 1) - maxF > k) {
                hash[s.charAt(l++) - 'A']--;
            }

            maxS = Math.max(maxS, r - l + 1);
        }
        return maxS;
    }

    public static int max(int[] nums) {
        int max = nums[0];
        for (int num: nums) max = Math.max(num, max);
        return max;
    }

    static void main() {
        System.out.println(characterReplacement2("ABAB", 2)); // 4
        System.out.println(characterReplacement2("AABABBA", 1)); // 4
    }
}
