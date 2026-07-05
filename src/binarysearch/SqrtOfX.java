package binarysearch;

public class SqrtOfX {
    public static int mySqrt(int x) {
        if (x <= 0) return 0;
        int l = 1, r = x, ans = 1;

        while (l < r) {
            int m = (l + r) / 2;
            if ((x / m) >= m) {
                ans = m;
                l = m + 1;
            } else r = m;
        }
        return ans;
    }

    static void main() {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }
}
