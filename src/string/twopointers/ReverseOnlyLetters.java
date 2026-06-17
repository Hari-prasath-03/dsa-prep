package string.twopointers;

public class ReverseOnlyLetters {
    static boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
    static void swap(char[] ch, int i, int j) {
        char t = ch[i];
        ch[i] = ch[j];
        ch[j] = t;
    }

    public static String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int l = 0, r = ch.length - 1;

        while (l < r) {
            while (l < r && !isLetter(ch[l])) l++;
            while (l < r && !isLetter(ch[r])) r--;
            swap(ch, l++, r--);
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd")); // "dc-ba"
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj")); // "j-Ih-gfE-dCba"
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!")); // "Qedo1ct-eeLg=ntse-T!"
    }
}
