package com.lm.demo.queue;

public class ArrayQueue {

    public int[] items;
    public int head;
    public int tail;
    public int capacity;

    public ArrayQueue (int capacity) {
        items = new int[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue (int item) {
        if (tail == capacity) {
            if (head == 0) return false;
            for (int i = head; i < tail ; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    public int dequeue () {
        if (tail == head) throw new RuntimeException("queue is empty");
        return items[head++];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
