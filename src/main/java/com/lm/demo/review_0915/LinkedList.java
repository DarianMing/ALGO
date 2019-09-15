package com.lm.demo.review_0915;

import com.lm.demo.list.Node;

public class LinkedList {

    public void findLastK (Node node , int k) {
        Node low = node;
        Node fast = node;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null){
            low = low.next;
            fast = fast.next;
        }
        System.out.println(low.data);
    }

    public void reversal (Node node) {
        Node pre = null;
        Node cur = node;
        while (cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        print(pre);
    }

    public void printTailToHead (Node node) {
        if (node != null) {
            printTailToHead(node.next);
            System.out.print(node.data + " ");
        }
    }

    public void findMidNode (Node node){
        Node low = node;
        Node fast = node;
        while (fast.next != null){
            low = low.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }[]
        System.out.println(low.data);
    }

    public void print (Node node){
        Node node1 = node;
        while (node1 != null){
            System.out.print(node1.data + " ");
            node1 = node1.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node node1 = Node.createNode(1);
        Node node2 = Node.createNode(2);
        Node node3 = Node.createNode(3);
        Node node4 = Node.createNode(4);
        Node node5 = Node.createNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LinkedList linkedList = new LinkedList();
//        linkedList.findLastK(node1 , 3);
        //linkedList.reversal(node1);
       // linkedList.printTailToHead(node1);
        linkedList.findMidNode(node1);
    }

}
