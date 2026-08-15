package variable_size_window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    // solution 1
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length(), maxS = 0;
        Set<Character> hash = new HashSet<>();

        int l = 0, r = 0;
        while (r < n) {
            char curr = s.charAt(r);
            if (!hash.contains(curr)) {
                hash.add(curr);
                maxS = Math.max(maxS, hash.size());
                r++;
            } else hash.remove(s.charAt(l++));
        }
        return maxS;
    }

    // solution 2
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), maxS = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int l = 0, r = 0;
        while (r < n) {
            char curr = s.charAt(r);
            if (hash[curr] != -1 && !(hash[curr] < l)) l = hash[curr] + 1;
            maxS = Math.max(r - l + 1, maxS);
            hash[curr] = r;
            r++;
        }
        return maxS;
    }

    static void main() {
        System.out.println(lengthOfLongestSubstring1("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring1("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring1("pwwkew")); // 3
    }
}
