package basicoperations;

public class StringToInteger {
    public static int myAtoi(String s) {
        int i = 0, res = 0, sign = 1, n = s.length();
        if (n == 0) return 0;

        while (i < n && s.charAt(i) == ' ') i++;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) sign = s.charAt(i++) == '-' ? -1 : 1;

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(i++) - '0');
        }

        return res * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi(" -042"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("0-1"));
    }
}
