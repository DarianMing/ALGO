package com.lm.demo.queue;

import com.lm.demo.list.Node;

public class LinkQueue {

    public Node head;
    public Node tail;

    public boolean enqueue (int item) {
        Node node = Node.createNode(item);
        if (tail == null){
            head = tail = node;
            return true;
        }
        tail.next = node;
        tail = node;
        return true;
    }

    public int dequeue () {
        if (head == null) throw new RuntimeException("queue is empty");
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
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
