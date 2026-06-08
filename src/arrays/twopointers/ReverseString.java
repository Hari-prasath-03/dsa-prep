package arrays.twopointers;

import java.util.Arrays;

public class ReverseString {
    static void swap(char[] s, int a, int b) {
        char t = s[a];
        s[a] = s[b];
        s[b] = t;
    }

    public static void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            swap(s, l++, r--);
        }
    }

    public static void main(String[] args) {
        var s = new char[] {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
