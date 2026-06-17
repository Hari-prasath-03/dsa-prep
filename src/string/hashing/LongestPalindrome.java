package string.hashing;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int longest = 0;
        int[] hash = new int[122];

        for (char ch: s.toCharArray()) {
            hash[ch]++;
        }

        boolean hasOdd = false;

        for (int cnt: hash) {
            if (cnt % 2 == 0) longest += cnt;
            else {
                hasOdd = true;
                longest += cnt - 1;
            }
        }

        return (hasOdd ? longest + 1: longest);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd")); // "dccaccd" 7
        System.out.println(longestPalindrome("a")); // "a" 1
    }
}
