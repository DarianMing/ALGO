package com.lm.demo.queue;

public class CircularQueue {

    public int[] items;
    public int head;
    public int tail;
    public int capacity;

    public CircularQueue (int capacity) {
        items = new int[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue (int item) {
        if ((tail + 1) % capacity == head) return false;
        items[tail] = item;
        tail = (tail + 1) % capacity;
//        if (tail == capacity - 1) {
//            items[tail] = item;
//            tail = 0;
//        } else {
//            items[tail++] = item;
//        }
        return true;
    }

    public int dequeue () {
        if (tail == head) throw new RuntimeException("queue is empty");
        int item = items[head];
        head = (head + 1) % capacity;
//        if (head == capacity - 1) {
//            item = items[head];
//            head = 0;
//        } else {
//            item = items[head++];
//        }
        return item;
    }

    public void printAll () {
        int h = head;
        while (tail != h) {
            System.out.print(items[h++] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printAll();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.printAll();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.printAll();
    }

}
