import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString {
    static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();

        int num = 0;
        StringBuilder res = new StringBuilder();
        for (char ch: s.toCharArray()) {
            if (isNumber(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(res);
                num = 0;
                res = new StringBuilder();
            } else if (ch == ']') {
                res = new StringBuilder(strStack.pop() + res.toString().repeat(numStack.pop()));
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static String decodeStringSingleStack(String s) {
        Deque<String> stack = new ArrayDeque<>();

        for (char ch: s.toCharArray()) {
            if (ch != ']') stack.push(String.valueOf(ch));
            else {
                StringBuilder temp = new StringBuilder();
                while (!"[".equals(stack.peek())) temp.insert(0, stack.pop());
                stack.pop();

                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && isNumber(stack.peek().charAt(0))) num.insert(0, stack.pop());

                String repeated = temp.toString().repeat(Integer.parseInt(num.toString()));
                stack.push(repeated);
            }
        }

        StringBuilder res = new StringBuilder();
        for (String str: stack) res.insert(0, str);
        return res.toString();
    }

    static void main() {
        System.out.println(decodeStringSingleStack("3[a]2[bc]")); // aaabcbc
        System.out.println(decodeStringSingleStack("3[a2[c]]")); // accaccacc
        System.out.println(decodeStringSingleStack("2[abc]3[cd]ef")); // abcabccdcdcdef
    }
}
