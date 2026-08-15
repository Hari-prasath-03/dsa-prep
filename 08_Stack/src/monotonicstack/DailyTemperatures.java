package monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
            if (!stack.isEmpty()) res[i] = stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    static void main() {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}))); // [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {30,40,50,60}))); // [1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {30,60,90}))); // [1,1,0]
    }
}
