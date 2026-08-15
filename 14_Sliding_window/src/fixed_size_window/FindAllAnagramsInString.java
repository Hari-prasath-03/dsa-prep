package fixed_size_window;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;

        int[] pHash = new int[26];
        for (char ch: p.toCharArray()) pHash[ch - 'a']++;

        int[] windowHash = new int[26];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            windowHash[s.charAt(r) - 'a']++;
            if (r - l + 1 > p.length()) windowHash[s.charAt(l++) - 'a']--;
            if (r - l + 1 == p.length() && isEqual(windowHash, pHash)) list.add(l);
        }

        return list;
    }

    private static boolean isEqual(int[] window, int[] src) {
        for (int i = 0; i < src.length; i++) {
            if (window[i] != src[i]) return false;
        }
        return true;
    }

    static void main() {
        System.out.println(findAnagrams("cbaebabacd", "abc")); // [0,6]
        System.out.println(findAnagrams("abab", "ab")); // [0,1,2]
    }
}
