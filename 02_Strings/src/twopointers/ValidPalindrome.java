package twopointers;

public class ValidPalindrome {
    private static boolean isAlphanumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left), r = s.charAt(right);

            if (!isAlphanumeric(l)) {
                left++; continue;
            }
            if (!isAlphanumeric(r)) {
                right--; continue;
            }

            if (l != r) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }
}
