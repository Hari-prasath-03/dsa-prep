package expressionevaluation;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {
    static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0, res = 0, sign = 1;

        for (char ch: s.toCharArray()) {
            if (isNumber(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+' || ch == '-') {
                res += sign * num;
                num = 0;
                sign = (ch == '+') ? 1 : -1;
            } else if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }

        res += sign * num;
        return res;
    }

    static void main() {
        System.out.println(calculate("1 + 1")); // 2
        System.out.println(calculate(" 2-1 + 2 ")); // 3
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)")); // 23
        System.out.println(calculate("1-(     -2)")); // 3
    }
}
