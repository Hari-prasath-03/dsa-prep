package twopointers;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
       StringBuilder sb = new StringBuilder();
       int l = 0, n = s.length();

       while (l < n) {
           while (l < n && s.charAt(l) == ' ') l++;
           if (l >= n) break;
           int r = l + 1;
           while (r < n && s.charAt(r) != ' ') r++;
           sb.insert(0, s.substring(l, r) + (sb.isEmpty() ? "" : " "));
           l = r + 1;
       }

       return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); // "blue is sky the"
        System.out.println(reverseWords("  hello world  ")); // "world hello"
        System.out.println(reverseWords("a good   example")); // "example good a"
    }
}
