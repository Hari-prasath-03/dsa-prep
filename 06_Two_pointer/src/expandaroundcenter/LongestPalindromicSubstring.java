package expandaroundcenter;

public class LongestPalindromicSubstring {
    static int expand(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            end++;
            start--;
        }
        return end - start - 1;
    }
    public static String longestPalindrome(String s) {
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }
        }
        return s.substring(start, start + maxLen);
    }

    static void main() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
