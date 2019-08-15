package com.lm.demo.stack;

import com.lm.demo.list.Node;

public class ListStack {

    public Node top;

    public void push (int item) {
        Node node = Node.createNode(item);
        if (top != null) {
            node.next = top;
        }
        top = node;
    }

    public int pop () {
        if (top == null) throw new RuntimeException("stack is empty");
        int data = top.data;
        top = top.next;
        return data;
    }

    public void printAll () {
        Node node = top;
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListStack stack = new ListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printAll();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
