package expressionevaluation;

import java.util.*;

public class EvaluateReversePolishNotation {
    static boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    static int calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token: tokens) {
            if (isOperator(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(calculate(num1, num2, token));
            } else stack.push(Integer.parseInt(token));
        }

        return stack.pop();
    }

    static void main() {
        System.out.println(evalRPN(new String[] {"2","1","+","3","*"})); // 9
        System.out.println(evalRPN(new String[] {"4","13","5","/","+"})); // 6
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"})); // 22
    }
}
