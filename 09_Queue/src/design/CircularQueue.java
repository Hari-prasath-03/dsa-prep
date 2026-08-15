package design;

import java.util.Arrays;

public class CircularQueue {
    private final int[] queue;
    private int front, rear, size;
    private final int capacity;

    public CircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "queue=" + Arrays.toString(queue) +
                ", front=" + front +
                ", rear=" + rear +
                ", size=" + size +
                '}';
    }

    public static void main() {
        CircularQueue queue = new CircularQueue(5);
        System.out.println(queue.enQueue(5));
        System.out.println(queue.enQueue(10));
        System.out.println(queue.enQueue(15));
        System.out.println(queue.enQueue(20));
        System.out.println(queue.enQueue(25));
        System.out.println(queue.enQueue(30));
        System.out.println(queue);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue);
        System.out.println(queue.enQueue(30));
        System.out.println(queue.enQueue(35));
        System.out.println(queue);
        System.out.println(queue.enQueue(40));
    }
}
