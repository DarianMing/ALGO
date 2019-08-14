package com.lm.demo.list;

/**
 * @author lm
 * @since 2019-08-14 19:16
 **/

public class Node {

    public int data;

    public Node next;

    public Node (int data , Node next) {
        this.data = data;
        this.next = next;
    }

    public static Node createNode (int value) {
        return new Node(value , null);
    }

}
