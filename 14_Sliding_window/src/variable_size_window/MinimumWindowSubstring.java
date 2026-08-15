package variable_size_window;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int n = s.length();
        if (t.length() > n) return "";

        int[] tHash = new int[128];
        for (char ch: t.toCharArray()) tHash[ch]++;

        int minLen = Integer.MAX_VALUE, start = 0;
        int[] windowHash = new int[128];

        int l = 0;
        for (int r = 0; r < n; r++) {
            windowHash[s.charAt(r)]++;

            while (contains(windowHash, tHash)) {
                int thisWindowLen = r - l + 1;
                if (thisWindowLen < minLen) {
                    minLen = thisWindowLen;
                    start = l;
                }
                windowHash[s.charAt(l++)]--;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    private static boolean contains(int[] checkWindow, int[] src) {
        for (int i = 0; i < src.length; i++) {
            if (checkWindow[i] < src[i]) return false;
        }
        return true;
    }

    static void main() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
