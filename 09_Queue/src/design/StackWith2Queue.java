package design;

import java.util.LinkedList;
import java.util.Queue;

public class StackWith2Queue {
    Queue<Integer> q;

    public StackWith2Queue() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        if (q.isEmpty()) return -1;
        return q.poll();
    }

    public int top() {
        if (q.isEmpty()) return -1;
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main() {
        StackWith2Queue s = new StackWith2Queue();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println(s.pop());
        System.out.println(s.pop());

        s.push(50);
        s.push(60);

        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
