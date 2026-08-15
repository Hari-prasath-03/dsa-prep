package design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private record Node(int num, int min) {}
    private final Deque<Node> stack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(new Node(value, value));
            return;
        }
        stack.push(new Node(value, Math.min(stack.peek().min, value)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().num;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
