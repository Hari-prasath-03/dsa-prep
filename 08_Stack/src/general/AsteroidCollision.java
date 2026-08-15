package general;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid: asteroids) {
            if (asteroid > 0) stack.push(asteroid);
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) stack.pop();
                if (stack.isEmpty() || stack.peek() < 0) stack.push(asteroid);
                if (!stack.isEmpty() && stack.peek() == -asteroid) stack.pop();
            }
        }

        int i = stack.size() - 1;
        int[] res = new int[stack.size()];
        while (!stack.isEmpty()) res[i--] = stack.pop();

        return res;
    }


    static void main() {
        System.out.println(Arrays.toString(asteroidCollision(new int[] {5,10,-5}))); // [5,10]
        System.out.println(Arrays.toString(asteroidCollision(new int[] {8,-8}))); // []
        System.out.println(Arrays.toString(asteroidCollision(new int[] {10,2,-5}))); // [10]
    }
}
