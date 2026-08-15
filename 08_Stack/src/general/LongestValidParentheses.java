package general;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int left = -1, max = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (stack.isEmpty()) left = i;
                else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, i - left);
                    else max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    static void main() {
        System.out.println(longestValidParentheses("(()")); // 2
        System.out.println(longestValidParentheses(")()())")); // 4
        System.out.println(longestValidParentheses("")); // 0
    }
}
